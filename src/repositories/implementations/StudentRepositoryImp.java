package repositories.implementations;

import models.Student;
import models.University;
import repositories.interfaces.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImp implements StudentRepository {
    private University university = University.getInstance();

    @Override
    public void add(Student student) {
        university.getStudents().add(student);
    }

    @Override
    public void update(Student student) {
        int index = university.getStudents().indexOf(student);
        if (index >= 0) {
            university.getStudents().set(index, student);
        }
    }

    @Override
    public void remove(Student student) {
        university.getStudents().remove(student);
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return university.getStudents().stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst();
    }

    @Override
    public List<Student> findAll() {
        return university.getStudents();
    }
}

