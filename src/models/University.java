package models;

import java.util.List;

public class University {
    private String universityName;
    private List<Teacher> teachers;
    private List<Student> students;
    private List<Class> classes;

    public University(String universityName, List<Teacher> teachers, List<Student> students, List<Class> classes) {
        this.universityName = universityName;
        this.teachers = teachers;
        this.students = students;
        this.classes = classes;
    }

    public String getUniversityName() {
        return universityName;
    }

    public List<Teacher> getTeachers() {
        return teachers;
    }

    public List<Student> getStudents() {
        return students;
    }

    public List<Class> getClasses() {
        return classes;
    }
}