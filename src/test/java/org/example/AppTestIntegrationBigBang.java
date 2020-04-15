package org.example;

import org.example.domain.Nota;
import org.example.domain.Pair;
import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.repository.NotaRepository;
import org.example.repository.StudentRepository;
import org.example.repository.TemaRepository;
import org.example.validation.NotaValidator;
import org.example.validation.StudentValidator;
import org.example.validation.TemaValidator;
import org.example.validation.Validator;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class AppTestIntegrationBigBang
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

        studentRepositoryMock = EasyMock.createMock(StudentRepository.class);

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
        Tema tema = new Tema("1", "desc", 8, 5);

        temaRepository.save(tema);
        assertEquals(tema, temaRepository.findOne("1"));
    }


    @Test
    public void testAddNotaValid()
    {
        Pair<String, String> pair = new Pair<>("1", "1");
        Nota nota = new Nota(pair, 10, 6, "bine, bă!");

        notaRepository.save(nota);
        assertEquals(nota, notaRepository.findOne(pair));
    }

    @Test
    public void testAll()
    {
        testAddStudentValid();
        testAddNotaValid();
        testAddNotaValid();
    }

}
