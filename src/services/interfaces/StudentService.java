package services.interfaces;

import models.Student;
import java.util.List;

public interface StudentService {
    void addStudent(Student student);
    void removeStudent(String studentId);
    Student getStudentById(String studentId);
    List<Student> getAllStudents();
    String formatStudentDetails(Student student);
    void printAllStudents();
}

