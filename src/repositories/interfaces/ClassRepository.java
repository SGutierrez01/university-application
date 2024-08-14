package repositories.interfaces;

import models.Class;
import java.util.List;
import java.util.Optional;

public interface ClassRepository {
    void add(Class newClass);
    void update(Class updatedClass);
    void remove(Class classToRemove);
    Optional<Class> findById(int classId);
    List<Class> findAll();
}

