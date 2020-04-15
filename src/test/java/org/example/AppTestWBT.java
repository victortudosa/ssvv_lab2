package org.example;

import org.example.domain.Tema;
import org.example.repository.TemaRepository;
import org.example.service.Service;
import org.example.validation.TemaValidator;
import org.example.validation.Validator;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class AppTestWBT {

    @Test
    public void testAddAssignmentValid() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        //Tema tema = new Tema(1, "descriere", 10, 12);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "descriere", 7, 6);

        assertEquals(result, 1);
    }

    @Test
    public void testAddAssignmentInvalidID() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        //Tema tema = new Tema(1, "descriere", 10, 12);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("", "descriere", 7, 6);

        assertEquals(result, 1);
    }

    @Test
    public void testValidInput1() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 14, 1);

        assertEquals(result, 1);
    }

    @Test
    public void testValidInput2() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("2", "desc", 7, 7);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidDuplicate() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 8, 6);
        result = service.saveTema("1", "desc", 8, 6);

        assertEquals(result, 0);
    }

    @Test
    public void testInvalidIdEmptyString() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("", "desc", 8, 6);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidDescriptionEmptyString() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "", 8, 6);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidDeadline() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 0, 6);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidStartline() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 8, 0);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidInterval() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 6, 7);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidIdNull() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema(null, "desc", 6, 7);

        assertEquals(result, 1);
    }

    @Test
    public void testInvalidDescriptionNull() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", null, 6, 7);

        assertEquals(result, 1);
    }
}
