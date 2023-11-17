package alura.com.br.agenda.dao;

import java.util.ArrayList;
import java.util.List;

import alura.com.br.agenda.model.Student;

public class StudentDAO {
    private final static List<Student> students = new ArrayList<>();

    public void save(Student student) {
        students.add(student);
    }

    public List<Student> allStudents() {
        return new ArrayList<>(students);
    }
}
