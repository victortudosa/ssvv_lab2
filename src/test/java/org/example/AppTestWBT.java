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
    public void test3() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 14, 1);

        assertEquals(result, 1);
    }

    @Test
    public void test4() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("2", "desc", 7, 7);

        assertEquals(result, 1);
    }

    @Test
    public void test5() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 8, 6);
        result = service.saveTema("1", "desc", 8, 6);

        assertEquals(result, 0);
    }

    @Test
    public void test6() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("", "desc", 8, 6);

        assertEquals(result, 1);
    }

    @Test
    public void test7() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "", 8, 6);

        assertEquals(result, 1);
    }

    @Test
    public void test8() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 0, 6);

        assertEquals(result, 1);
    }

    @Test
    public void test9() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 8, 0);

        assertEquals(result, 1);
    }

    @Test
    public void test10() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", "desc", 6, 7);

        assertEquals(result, 1);
    }

    @Test
    public void test11() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema(null, "desc", 6, 7);

        assertEquals(result, 1);
    }

    @Test
    public void test12() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("1", null, 6, 7);

        assertEquals(result, 1);
    }


}
