package org.example;

import org.example.domain.Student;
import org.example.repository.StudentRepository;
import org.example.validation.StudentValidator;
import org.example.validation.ValidationException;
import org.example.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void testAddStudentRepo()
    {
        Student student = new Student("1", "nume", 123);
        Student student2 = new Student("2", "nume2", 222);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);
        repo.save(student);
        assertEquals(student, repo.findOne("1"));

        assertNotEquals(student2, repo.findOne("1"));
    }

    @Test
    public void testAddStudentRepoWhenInvalidDataThrowsException()
    {
        Student student = new Student("", "nume", 123);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);
        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), "ID invalid! \n");
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidID()
    {
        Student student = new Student("abc", "nume", 123);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);
        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), "ID invalid! \n");
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidID2()
    {
        Student student = new Student("-1", "nume", 123);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);
        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);
        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals(e.getMessage(), "ID invalid! \n");
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }

    @Test
    public void testAddStudentInvalidName()
    {
        Student student = new Student("1", "", 123);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Nume invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidName2()
    {
        Student student = new Student("1", "nume 1 das!!", 123);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Campul Nume trebuie sa contina doar litere si spatii \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidName3()
    {
        Student student = new Student("1", "   ", 123);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Campul Nume trebuie sa contina doar litere si spatii \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }

    @Test
    public void testAddStudentInvalidGroup()
    {
        Student student = new Student("1", "nume", 0);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Grupa invalida! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }

    @Test
    public void testAddStudentInvalidGroup2()
    {
        Student student = new Student("1", "nume", 110);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Grupa invalida! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidGroup3()
    {
        Student student = new Student("1", "nume", 938);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Grupa invalida! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidGroup4()
    {
        Student student = new Student("1", "nume", 100);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Grupa invalida! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentValidGroup()
    {
        Student student = new Student("1", "nume", 200);
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        repo.save(student);

        assertEquals(student, repo.findOne("1"));
    }




}
