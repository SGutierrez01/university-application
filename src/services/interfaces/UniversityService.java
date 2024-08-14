package services.interfaces;

import models.Class;
import models.Student;
import models.Teacher;
import java.util.List;

public interface UniversityService {
    List<Teacher> getAllTeachers();
    List<Student> getAllStudents();
    List<Class> getAllClasses();
    void printAllTeachers();
    void printAllStudents();
    void printAllClasses();
}
