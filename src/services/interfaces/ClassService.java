package services.interfaces;

import models.Class;
import java.util.List;

public interface ClassService {
    void addClass(Class newClass);
    void removeClass(String className);
    Class getClassByName(String className);
    List<Class> getAllClasses();
    String formatClassDetails(Class classObj);
    void printAllClasses();
    void printClassDetails(Class classObj);
}
