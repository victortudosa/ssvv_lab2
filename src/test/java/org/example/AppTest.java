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
        Student student = new Student("1", "nume prenume", 123, "test@test.com", "nume");
        Student student2 = new Student("2", "nume prenume", 222, "test@test.com", "nume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);
        repo.save(student);
        assertEquals(student, repo.findOne("1"));

        assertNotEquals(student2, repo.findOne("1"));
    }

    @Test
    public void testAddStudentRepoWhenInvalidDataThrowsException()
    {
        Student student = new Student("", "nume", 123, "test@test.com", "nume");
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
        Student student = new Student("abc", "nume", 123, "test@test.com", "nume");
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
        Student student = new Student("-1", "nume", 123, "test@test.com", "nume");
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
        Student student = new Student("1", "", 123, "test@test.com", "nume");
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
        Student student = new Student("1", "nume 1 prenume", 123, "test@test.com", "nume");
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
        Student student = new Student("1", "nume penume!!", 123, "test@test.com", "nume");
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
    public void testAddStudentInvalidName4()
    {
        Student student = new Student("1", "   ", 123, "test@test.com", "nume");
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
        Student student = new Student("1", "nume", 0, "test@test.com", "nume");
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
        Student student = new Student("1", "nume", 110, "test@test.com", "nume");
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
        Student student = new Student("1", "nume", 938, "test@test.com", "nume");
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
        Student student = new Student("1", "nume", 100, "test@test.com", "nume");
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
        Student student = new Student("1", "nume", 200, "test@test.com", "nume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        repo.save(student);
        assertEquals(student, repo.findOne("1"));
    }

    @Test
    public void testAddStudentInvalidEmail()
    {
        Student student = new Student("1", "nume", 200, "", "nume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Email invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidEmail2()
    {
        Student student = new Student("1", "nume", 200, "email", "nume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Email invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidEmail3()
    {
        Student student = new Student("1", "nume", 200, "email@domain", "nume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Email invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentValidEmail()
    {
        Student student = new Student("1", "nume", 200, "email@domain.com", "nume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        repo.save(student);
        assertEquals(student, repo.findOne("1"));
    }

    @Test
    public void testAddStudentInvalidTutor()
    {
        Student student = new Student("1", "nume", 200, "email@domain.com", "");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Tutor invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidTutor2()
    {
        Student student = new Student("1", "nume", 123, "test@test.com", "nume 1 prenume");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Tutor invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidTutor3()
    {
        Student student = new Student("1", "nume", 123, "test@test.com", "nume prenume!!");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Tutor invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
    @Test
    public void testAddStudentInvalidTutor4()
    {
        Student student = new Student("1", "nume", 123, "test@test.com", "   ");
        Validator<Student> validator = new StudentValidator();
        StudentRepository repo = new StudentRepository(validator);

        try {
            repo.save(student);
            assertTrue("It should throw ValidationException", false);

        } catch (ValidationException e) {
            System.out.println(e.getMessage());
            assertEquals("Tutor invalid! \n", e.getMessage());
        } catch (Exception e) {
            assertTrue("It should throw ValidationException", false);
        }
    }
}
