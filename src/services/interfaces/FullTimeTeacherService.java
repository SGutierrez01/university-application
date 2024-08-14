package services.interfaces;

import models.FullTimeTeacher;

public interface FullTimeTeacherService {
    double calculateSalary(FullTimeTeacher teacher);
    String formatTeacherDetails(FullTimeTeacher teacher);
}
