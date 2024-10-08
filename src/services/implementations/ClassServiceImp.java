package services.implementations;

import models.Class;
import models.FullTimeTeacher;
import models.PartTimeTeacher;
import models.Student;
import repositories.interfaces.ClassRepository;
import services.interfaces.ClassService;
import services.interfaces.FullTimeTeacherService;
import services.interfaces.PartTimeTeacherService;
import services.interfaces.StudentService;
import java.util.List;

public class ClassServiceImp implements ClassService {

    private ClassRepository classRepository;
    private StudentService studentService;
    private FullTimeTeacherService fullTimeTeacherService;
    private PartTimeTeacherService partTimeTeacherService;

    public ClassServiceImp(ClassRepository classRepository, StudentService studentService, FullTimeTeacherService fullTimeTeacherService, PartTimeTeacherService partTimeTeacherService) {
        this.classRepository = classRepository;
        this.studentService = studentService;
        this.fullTimeTeacherService = fullTimeTeacherService;
        this.partTimeTeacherService = partTimeTeacherService;
    }

    @Override
    public void addClass(Class newClass) {
        classRepository.add(newClass);
    }

    @Override
    public void removeClass(int classId) {
        Class classObj = getClassById(classId);
        if (classObj != null) {
            classRepository.remove(classObj);
        }
    }

    @Override
    public Class getClassById(int classId) {
        return classRepository.findById(classId).orElse(null);
    }

    @Override
    public List<Class> getAllClasses() {
        return classRepository.findAll();
    }

    @Override
    public void printAllClasses() {
        getAllClasses().forEach(classObj -> System.out.println("\n- " + classObj.getName() + ": ID "+ classObj.getClassId()));
    }

    @Override
    public void printClassDetails(Class classObj) {
        System.out.println(formatClassDetails(classObj));
    }

    @Override
    public void addStudentToClass(int classId, Student student) {
        Class classObj = classRepository.findById(classId).orElse(null);
        if (classObj != null) {
            classObj.getStudents().add(student);
            classRepository.update(classObj);
            System.out.println("\nStudent added to the class successfully.");
            printClassDetails(classObj);
        } else {
            System.out.println("Class not found.");
        }
    }

    private String formatClassDetails(Class classObj) {
        String teacherDetails = classObj.getTeacher() instanceof FullTimeTeacher ?
                fullTimeTeacherService.formatTeacherDetails((FullTimeTeacher) classObj.getTeacher()) :
                partTimeTeacherService.formatTeacherDetails((PartTimeTeacher) classObj.getTeacher());

        StringBuilder studentDetails = new StringBuilder();
        classObj.getStudents().forEach(student -> studentDetails.append(studentService.formatStudentDetails(student)).append("\n"));

        return String.format("\nClass [ID: %d, Name: %s]\nTeacher: %s\nStudents:\n%s",
                classObj.getClassId(), classObj.getName(), teacherDetails, studentDetails.toString());
    }
}

