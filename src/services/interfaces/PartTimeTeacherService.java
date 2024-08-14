package services.interfaces;

import models.PartTimeTeacher;
import java.util.List;

public interface PartTimeTeacherService {
    double calculateSalary(PartTimeTeacher teacher);
    String formatTeacherDetails(PartTimeTeacher teacher);
    void addPartTimeTeacher(PartTimeTeacher teacher);
    void removePartTimeTeacher(String teacherId);
    PartTimeTeacher getPartTimeTeacherById(String teacherId);
    List<PartTimeTeacher> getAllPartTimeTeachers();
}
