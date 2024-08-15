package models;

import java.util.ArrayList;
import java.util.List;

public class University {
    private static University instance;
    private String name;
    private List<Teacher> teachers = new ArrayList<>();
    private List<Student> students = new ArrayList<>();
    private List<Class> classes = new ArrayList<>();

    private University() {
    }

    public static University getInstance() {
        if (instance == null) {
            instance = new University();
        }
        return instance;
    }


    public String getName() {
        return name;
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