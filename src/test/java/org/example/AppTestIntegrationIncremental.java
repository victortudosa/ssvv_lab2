package org.example;

import org.example.domain.Nota;
import org.example.domain.Pair;
import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.repository.NotaRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TemaRepository;
import org.example.validation.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;


public class AppTestIntegrationIncremental
{
    StudentRepository studentRepository;
    TemaRepository temaRepository;
    NotaRepository notaRepository;


    @Before
    public void setUp()
    {
        Validator<Student> studentValidator = new StudentValidator();
        studentRepository = new StudentRepository(studentValidator);

        Validator<Tema> temaValidator = new TemaValidator();
        temaRepository = new TemaRepository(temaValidator);

        Validator<Nota> notaValidator = new NotaValidator();
        notaRepository = new NotaRepository(notaValidator);
    }


    @After
    public void tearDown()
    {
        studentRepository = null;
        temaRepository = null;
        notaRepository = null;
    }


    @Test
    public void testAddStudentValid()
    {
        Student student = new Student("1", "nume", 200, "email@domain.com", "nume");

        studentRepository.save(student);
        assertEquals(student, studentRepository.findOne("1"));
    }


    @Test
    public void testAddTemaValid()
    {
        testAddStudentValid();

        Tema tema = new Tema("1", "desc", 8, 5);

        temaRepository.save(tema);
        assertEquals(tema, temaRepository.findOne("1"));
    }


    @Test
    public void testAddNotaNotValid()
    {
        testAddStudentValid();
        testAddTemaValid();

        Pair<String, String> pair = new Pair<>("1", "1");
        Nota nota = new Nota(pair, 11, 7, "bine, bă!");

        try
        {
            notaRepository.save(nota);
            fail("It should throw ValidationException");
        }
        catch (ValidationException e)
        {
            System.out.println(e.getMessage());
            assertEquals("Nota invalida! \n", e.getMessage());
        }
        catch (Exception e)
        {
            fail("It should throw ValidationException");
        }
    }
}
