package models;

import java.util.ArrayList;
import java.util.List;

import java.util.List;

public class Class {
    private int classId;
    private String className;
    private ClassRoom classRoom;
    private Teacher teacher;
    private List<Student> students;

    public Class(int classId, String className, ClassRoom classRoom,Teacher teacher, List<Student> students) {
        this.classId = classId;
        this.className = className;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.students = students;
    }

    public int getClassId() {
        return classId;
    }

    public String getClassName() {
        return className;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}


