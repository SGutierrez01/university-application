package services.implementations;

import models.Class;
import models.FullTimeTeacher;
import models.PartTimeTeacher;
import repositories.interfaces.ClassRepository;
import services.interfaces.ClassService;
import services.interfaces.FullTimeTeacherService;
import services.interfaces.PartTimeTeacherService;
import services.interfaces.StudentService;
import java.util.List;

public class ClassServiceImp implements ClassService {

    private ClassRepository classRepository;

    public ClassServiceImp(ClassRepository classRepository) {
        this.classRepository = classRepository;
    }

    @Override
    public void addClass(Class newClass) {
        classRepository.add(newClass);
    }

    @Override
    public void removeClass(String className) {
        Class classObj = getClassByName(className);
        if (classObj != null) {
            classRepository.remove(classObj);
        }
    }

    @Override
    public Class getClassByName(String className) {
        return classRepository.findById(className.hashCode()).orElse(null);
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public String formatClassDetails(Class classObj) {
        String teacherDetails = classObj.getTeacher() instanceof FullTimeTeacher ?
                ((FullTimeTeacherService) this).formatTeacherDetails((FullTimeTeacher) classObj.getTeacher()) :
                ((PartTimeTeacherService) this).formatTeacherDetails((PartTimeTeacher) classObj.getTeacher());

        StringBuilder studentDetails = new StringBuilder();
        classObj.getStudents().forEach(student -> studentDetails.append(((StudentService) this).formatStudentDetails(student)).append("\n"));

        return String.format("Class [ID: %d, Name: %s]\nTeacher: %s\nStudents:\n%s",
                classObj.getClassId(), classObj.getName(), teacherDetails, studentDetails.toString());
    }

    @Override
    public void printAllClasses() {
        getAllClasses().forEach(classObj -> System.out.println(formatClassDetails(classObj)));
    }

    @Override
    public void printClassDetails(Class classObj) {
        System.out.println(formatClassDetails(classObj));
    }
}

