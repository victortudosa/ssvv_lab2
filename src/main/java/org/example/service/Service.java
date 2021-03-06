package org.example.service;

import org.example.domain.Nota;
import org.example.domain.Pair;
import org.example.domain.Student;
import org.example.domain.Tema;
import org.example.repository.NotaXMLRepository;
import org.example.repository.StudentXMLRepository;
import org.example.repository.TemaRepository;
import org.example.validation.ValidationException;

import java.time.LocalDate;
import java.time.temporal.WeekFields;
import java.util.Locale;


public class Service
{
    private StudentXMLRepository studentXmlRepo;
    private TemaRepository temaRepo;
    private NotaXMLRepository notaXmlRepo;


    public Service(StudentXMLRepository studentXmlRepo, TemaRepository temaRepo, NotaXMLRepository notaXmlRepo)
    {
        this.studentXmlRepo = studentXmlRepo;
        this.temaRepo = temaRepo;
        this.notaXmlRepo = notaXmlRepo;
    }


    public Iterable<Student> findAllStudents()
    {
        return studentXmlRepo.findAll();
    }


    public Iterable<Tema> findAllTeme()
    {
        return temaRepo.findAll();
    }


    public Iterable<Nota> findAllNote()
    {
        return notaXmlRepo.findAll();
    }


    public int saveStudent(String id, String nume, int grupa, String email, String tutor)
    {
        Student student = new Student(id, nume, grupa, email, tutor);
        Student result = studentXmlRepo.save(student);

        if (result == null)
        {
            return 1;
        }
        return 0;
    }


    public int saveTema(String id, String descriere, int deadline, int startline)
    {

        try
        {
            Tema tema = new Tema(id, descriere, deadline, startline);
            Tema result = temaRepo.save(tema);

            if (result == null)
            {
                return 0;
            }
            return 1;
        }
        catch (ValidationException ve)
        {
            return 1;
        }
    }


    public int saveNota(String idStudent, String idTema, double valNota, int predata, String feedback)
    {
        if (studentXmlRepo.findOne(idStudent) == null || temaRepo.findOne(idTema) == null)
        {
            return -1;
        }
        else
        {
            int deadline = temaRepo.findOne(idTema).getDeadline();

            if (predata - deadline > 2)
            {
                valNota = 1;
            }
            else
            {
                valNota = valNota - 2.5 * (predata - deadline);
            }
            Nota nota = new Nota(new Pair(idStudent, idTema), valNota, predata, feedback);
            Nota result = notaXmlRepo.save(nota);

            if (result == null)
            {
                return 1;
            }
            return 0;
        }
    }


    public int deleteStudent(String id)
    {
        Student result = studentXmlRepo.delete(id);

        if (result == null)
        {
            return 0;
        }
        return 1;
    }


    public int deleteTema(String id)
    {
        Tema result = temaRepo.delete(id);

        if (result == null)
        {
            return 0;
        }
        return 1;
    }


    public int updateStudent(String id, String numeNou, int grupaNoua, String emailNou, String tutorNou)
    {
        Student studentNou = new Student(id, numeNou, grupaNoua, "", "");
        Student result = studentXmlRepo.update(studentNou);

        if (result == null)
        {
            return 0;
        }
        return 1;
    }


    public int updateTema(String id, String descriereNoua, int deadlineNou, int startlineNou)
    {
        Tema temaNoua = new Tema(id, descriereNoua, deadlineNou, startlineNou);
        Tema result = temaRepo.update(temaNoua);

        if (result == null)
        {
            return 0;
        }
        return 1;
    }


    public int extendDeadline(String id, int noWeeks)
    {
        Tema tema = temaRepo.findOne(id);

        if (tema != null)
        {
            LocalDate date = LocalDate.now();
            WeekFields weekFields = WeekFields.of(Locale.getDefault());
            int currentWeek = date.get(weekFields.weekOfWeekBasedYear());

            if (currentWeek >= 39)
            {
                currentWeek = currentWeek - 39;
            }
            else
            {
                currentWeek = currentWeek + 12;
            }

            if (currentWeek <= tema.getDeadline())
            {
                int deadlineNou = tema.getDeadline() + noWeeks;
                return updateTema(tema.getID(), tema.getDescriere(), deadlineNou, tema.getStartline());
            }
        }
        return 0;
    }


    public void createStudentFile(String idStudent, String idTema)
    {
        Nota nota = notaXmlRepo.findOne(new Pair(idStudent, idTema));

        notaXmlRepo.createFile(nota);
    }
}
