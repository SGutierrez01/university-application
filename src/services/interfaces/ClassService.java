package services.interfaces;

import models.Class;
import models.Student;

import java.util.List;

public interface ClassService {
    void addClass(Class newClass);
    void removeClass(int classId);
    Class getClassById(int classId);
    List<Class> getAllClasses();
    void printAllClasses();
    void printClassDetails(Class classObj);
    void addStudentToClass(int classId, Student student);
}
