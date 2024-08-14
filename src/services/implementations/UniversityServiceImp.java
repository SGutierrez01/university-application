package services.implementations;

import models.Class;
import models.Student;
import models.Teacher;
import services.interfaces.*;
import java.util.ArrayList;
import java.util.List;

public class UniversityServiceImp implements UniversityService {

    private FullTimeTeacherService fullTimeTeacherService;
    private PartTimeTeacherService partTimeTeacherService;
    private StudentService studentService;
    private ClassService classService;

    public UniversityServiceImp(FullTimeTeacherService fullTimeTeacherService,
                                PartTimeTeacherService partTimeTeacherService,
                                StudentService studentService,
                                ClassService classService) {
        this.fullTimeTeacherService = fullTimeTeacherService;
        this.partTimeTeacherService = partTimeTeacherService;
        this.studentService = studentService;
        this.classService = classService;
    }

    @Override
    public List<Teacher> getAllTeachers() {
        List<Teacher> teachers = new ArrayList<>();
        teachers.addAll(fullTimeTeacherService.getAllFullTimeTeachers());
        teachers.addAll(partTimeTeacherService.getAllPartTimeTeachers());
        return teachers;
    }

    @Override
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @Override
    public List<Class> getAllClasses() {
        return classService.getAllClasses();
    }

    @Override
    public void printAllTeachers() {
        fullTimeTeacherService.getAllFullTimeTeachers().forEach(teacher ->
                System.out.println(fullTimeTeacherService.formatTeacherDetails(teacher)));
        partTimeTeacherService.getAllPartTimeTeachers().forEach(teacher ->
                System.out.println(partTimeTeacherService.formatTeacherDetails(teacher)));
    }

    @Override
    public void printAllStudents() {
        studentService.printAllStudents();
    }

    @Override
    public void printAllClasses() {
        classService.printAllClasses();
    }
}

