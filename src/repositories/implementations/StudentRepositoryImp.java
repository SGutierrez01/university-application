package repositories.implementations;

import models.Student;
import repositories.interfaces.StudentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepositoryImp implements StudentRepository {
    private List<Student> students = new ArrayList<>();

    @Override
    public void add(Student student) {
        students.add(student);
    }

    @Override
    public void update(Student student) {
        int index = students.indexOf(student);
        if (index >= 0) {
            students.set(index, student);
        }
    }

    @Override
    public void remove(Student student) {
        students.remove(student);
    }

    @Override
    public Optional<Student> findById(String studentId) {
        return students.stream()
                .filter(s -> s.getStudentId().equals(studentId))
                .findFirst();
    }

    @Override
    public List<Student> findAll() {
        return new ArrayList<>(students);
    }
}

