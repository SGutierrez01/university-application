package repositories.implementations;

import models.Class;
import repositories.interfaces.ClassRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ClassRepositoryImp implements ClassRepository {
    private List<Class> classes = new ArrayList<>();

    @Override
    public void add(Class newClass) {
        classes.add(newClass);
    }

    @Override
    public void update(Class updatedClass) {
        int index = classes.indexOf(updatedClass);
        if (index >= 0) {
            classes.set(index, updatedClass);
        }
    }

    @Override
    public void remove(Class classToRemove) {
        classes.remove(classToRemove);
    }

    @Override
    public Optional<Class> findById(int classId) {
        return classes.stream()
                .filter(c -> c.getClassId() == classId)
                .findFirst();
    }

    @Override
    public List<Class> findAll() {
        return new ArrayList<>(classes);
    }
}
