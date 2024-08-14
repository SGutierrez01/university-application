package repositories.interfaces;

import models.Student;
import java.util.List;
import java.util.Optional;

public interface StudentRepository {
    void add(Student student);
    void update(Student student);
    void remove(Student student);
    Optional<Student> findById(String studentId);
    List<Student> findAll();
}

