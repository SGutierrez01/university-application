package repositories.implementations;

import models.FullTimeTeacher;
import models.PartTimeTeacher;
import models.University;
import repositories.interfaces.FullTimeTeacherRepository;
import repositories.interfaces.PartTimeTeacherRepository;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImp implements FullTimeTeacherRepository, PartTimeTeacherRepository {
    private University university = University.getInstance();

    @Override
    public void add(FullTimeTeacher teacher) {
        university.getTeachers().add(teacher);
    }

    @Override
    public void update(FullTimeTeacher teacher) {
        int index = university.getTeachers().indexOf(teacher);
        if (index >= 0) {
            university.getTeachers().set(index, teacher);
        }
    }

    @Override
    public void remove(FullTimeTeacher teacher) {
        university.getTeachers().remove(teacher);
    }

    @Override
    public Optional<FullTimeTeacher> findFullTimeTeacherById(String teacherId) {
        return university.getTeachers().stream()
                .filter(t -> t instanceof FullTimeTeacher && t.getTeacherId().equals(teacherId))
                .map(t -> (FullTimeTeacher) t)
                .findFirst();
    }

    @Override
    public List<FullTimeTeacher> findAllFullTimeTeachers() {
        return university.getTeachers().stream()
                .filter(t -> t instanceof FullTimeTeacher)
                .map(t -> (FullTimeTeacher) t)
                .toList();
    }

    @Override
    public void add(PartTimeTeacher teacher) {
        university.getTeachers().add(teacher);
    }

    @Override
    public void update(PartTimeTeacher teacher) {
        int index = university.getTeachers().indexOf(teacher);
        if (index >= 0) {
            university.getTeachers().set(index, teacher);
        }
    }

    @Override
    public void remove(PartTimeTeacher teacher) {
        university.getTeachers().remove(teacher);
    }

    @Override
    public Optional<PartTimeTeacher> findPartTimeTeacherById(String teacherId) {
        return university.getTeachers().stream()
                .filter(t -> t instanceof PartTimeTeacher && t.getTeacherId().equals(teacherId))
                .map(t -> (PartTimeTeacher) t)
                .findFirst();
    }

    @Override
    public List<PartTimeTeacher> findAllPartTimeTeachers() {
        return university.getTeachers().stream()
                .filter(t -> t instanceof PartTimeTeacher)
                .map(t -> (PartTimeTeacher) t)
                .toList();
    }
}

