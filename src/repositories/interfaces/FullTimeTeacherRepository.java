package repositories.interfaces;

import models.FullTimeTeacher;
import java.util.List;
import java.util.Optional;

public interface FullTimeTeacherRepository {
    void add(FullTimeTeacher teacher);
    void update(FullTimeTeacher teacher);
    void remove(FullTimeTeacher teacher);
    Optional<FullTimeTeacher> findFullTimeTeacherById(String teacherId);
    List<FullTimeTeacher> findAllFullTimeTeachers();
}

