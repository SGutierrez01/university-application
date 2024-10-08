package repositories.interfaces;

import models.PartTimeTeacher;
import java.util.List;
import java.util.Optional;

public interface PartTimeTeacherRepository {
    void add(PartTimeTeacher teacher);
    void update(PartTimeTeacher teacher);
    void remove(PartTimeTeacher teacher);
    Optional<PartTimeTeacher> findPartTimeTeacherById(String teacherId);
    List<PartTimeTeacher> findAllPartTimeTeachers();
}

