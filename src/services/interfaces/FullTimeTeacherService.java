package services.interfaces;

import models.FullTimeTeacher;
import java.util.List;

public interface FullTimeTeacherService {
    double calculateSalary(FullTimeTeacher teacher);
    String formatTeacherDetails(FullTimeTeacher teacher);
    void addFullTimeTeacher(FullTimeTeacher teacher);
    void removeFullTimeTeacher(String teacherId);
    FullTimeTeacher getFullTimeTeacherById(String teacherId);
    List<FullTimeTeacher> getAllFullTimeTeachers();
}
