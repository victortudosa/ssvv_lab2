package org.example.validation;

import org.example.domain.Student;

public class StudentValidator implements Validator<Student> {
    public void validate(Student student) throws ValidationException {
        if (student.getID() == null || student.getID().equals("")) {
            throw new ValidationException("ID invalid! \n");
        }
        /*if (Pattern.matches("[a-zA-Z]+", student.getID())) {
            throw new ValidationException("ID invalid! \n");
        }
        if (Integer.parseInt(student.getID()) <= 0) {
            throw new ValidationException("ID invalid! \n");
        }*/

        if (student.getNume() == null || student.getNume().equals("")) {
            throw new ValidationException("Nume invalid! \n");
        }
        /*Pattern p = Pattern.compile("^[ A-Za-z]+$");
        Matcher m = p.matcher(student.getNume());
        boolean b = m.matches();
        if (!b || student.getNume().replaceAll("\\s+","").equals("") ) {
            throw new ValidationException("Campul Nume trebuie sa contina doar litere si spatii \n");
        }*/

        if (student.getGrupa() <= 110 || student.getGrupa() >= 938) {
            throw new ValidationException("Grupa invalida! \n");
        }
    }
}

