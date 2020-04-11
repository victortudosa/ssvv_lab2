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

        assertEquals(result, 0);
    }

    @Test
    public void testAddAssignmentInvalidID() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        //Tema tema = new Tema(1, "descriere", 10, 12);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("", "descriere", 7, 6);

        assertEquals(result, 0);
    }

    @Test
    public void testtest() {

        Validator<Tema> validator = new TemaValidator();
        TemaRepository repo = new TemaRepository(validator);

        //Tema tema = new Tema(1, "descriere", 10, 12);

        Service service = new Service(null, repo, null);

        int result = service.saveTema("", "descriere", 7, 6);

        assertEquals(result, 0);
    }

}
