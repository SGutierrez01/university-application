package repositories.implementations;

import models.Class;
import models.University;
import repositories.interfaces.ClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassRepositoryImp implements ClassRepository {
    private University university = University.getInstance();

    @Override
    public void add(Class newClass) {
        university.getClasses().add(newClass);
    }

    @Override
    public void update(Class updatedClass) {
        int index = university.getClasses().indexOf(updatedClass);
        if (index >= 0) {
            university.getClasses().set(index, updatedClass);
        }
    }

    @Override
    public void remove(Class classToRemove) {
        university.getClasses().remove(classToRemove);
    }

    @Override
    public Optional<Class> findById(int classId) {
        return university.getClasses().stream()
                .filter(c -> c.getClassId() == classId)
                .findFirst();
    }

    @Override
    public List<Class> findAll() {
        return university.getClasses();
    }
}
