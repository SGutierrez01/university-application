package services.interfaces;

import models.PartTimeTeacher;

public interface PartTimeTeacherService {
    double calculateSalary(PartTimeTeacher teacher);
    String formatTeacherDetails(PartTimeTeacher teacher);
}
