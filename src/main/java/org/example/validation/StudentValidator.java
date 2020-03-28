package org.example.validation;

import org.example.domain.Student;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StudentValidator implements Validator<Student> {
    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("")) {
            throw new ValidationException("ID invalid! \n");
        }
        if (Pattern.matches("[a-zA-Z]+", student.getID())) {
            throw new ValidationException("ID invalid! \n");
        }
        if (Integer.parseInt(student.getID()) <= 0) {
            throw new ValidationException("ID invalid! \n");
        }

        if (student.getNume() == null || student.getNume().equals("")) {
            throw new ValidationException("Nume invalid! \n");
        }
        Pattern p = Pattern.compile("^[ A-Za-z]+$");
        Matcher m = p.matcher(student.getNume());
        boolean b = m.matches();
        if (!b || student.getNume().replaceAll("\\s+","").equals("") ) {
            throw new ValidationException("Campul Nume trebuie sa contina doar litere si spatii \n");
        }

        if (student.getGrupa() <= 110 || student.getGrupa() >= 938) {
            throw new ValidationException("Grupa invalida! \n");
        }

        if (student.getEmail() == null || student.getEmail().equals("")) {
            throw new ValidationException("Email invalid! \n");
        }
        String emailRegex = "^[a-zA-Z0-9_-]+(?:\\."+
                "[a-zA-Z0-9_-]+)*@" +
                "(?:[a-zA-Z0-9-]+\\.)+[a-z" +
                "A-Z]+$";
        if (!Pattern.matches(emailRegex, student.getEmail())) {
            throw new ValidationException("Email invalid! \n");
        }

        if (student.getTutor() == null || student.getTutor().equals("")) {
            throw new ValidationException("Tutor invalid! \n");
        }
        m = p.matcher(student.getTutor());
        b = m.matches();
        if (!b || student.getTutor().replaceAll("\\s+","").equals("") ) {
            throw new ValidationException("Tutor invalid! \n");
        }
    }
}

