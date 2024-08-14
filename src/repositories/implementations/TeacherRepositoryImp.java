package repositories.implementations;

import models.FullTimeTeacher;
import models.PartTimeTeacher;
import repositories.interfaces.FullTimeTeacherRepository;
import repositories.interfaces.PartTimeTeacherRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TeacherRepositoryImp implements FullTimeTeacherRepository, PartTimeTeacherRepository {
    private List<FullTimeTeacher> fullTimeTeachers = new ArrayList<>();
    private List<PartTimeTeacher> partTimeTeachers = new ArrayList<>();

    @Override
    public void add(FullTimeTeacher teacher) {
        fullTimeTeachers.add(teacher);
    }

    @Override
    public void update(FullTimeTeacher teacher) {
        int index = fullTimeTeachers.indexOf(teacher);
        if (index >= 0) {
            fullTimeTeachers.set(index, teacher);
        }
    }

    @Override
    public void remove(FullTimeTeacher teacher) {
        fullTimeTeachers.remove(teacher);
    }

    @Override
    public Optional<FullTimeTeacher> findById(String teacherId) {
        return fullTimeTeachers.stream()
                .filter(t -> t.getTeacherId().equals(teacherId))
                .findFirst();
    }

    @Override
    public List<FullTimeTeacher> findAll() {
        return new ArrayList<>(fullTimeTeachers);
    }

    @Override
    public void add(PartTimeTeacher teacher) {
        partTimeTeachers.add(teacher);
    }

    @Override
    public void update(PartTimeTeacher teacher) {
        int index = partTimeTeachers.indexOf(teacher);
        if (index >= 0) {
            partTimeTeachers.set(index, teacher);
        }
    }

    @Override
    public void remove(PartTimeTeacher teacher) {
        partTimeTeachers.remove(teacher);
    }

    @Override
    public Optional<PartTimeTeacher> findById(String teacherId) {
        return partTimeTeachers.stream()
                .filter(t -> t.getTeacherId().equals(teacherId))
                .findFirst();
    }

    @Override
    public List<PartTimeTeacher> findAll() {
        return new ArrayList<>(partTimeTeachers);
    }
}

