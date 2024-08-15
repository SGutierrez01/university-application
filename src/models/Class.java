package models;
import java.util.ArrayList;
import java.util.List;

public class Class {
    private int classId;
    private String name;
    private String classRoom;
    private Teacher teacher;
    private List<Student> students;

    public Class(int classId, String name, String classRoom,Teacher teacher, List<Student> students) {
        this.classId = classId;
        this.name = name;
        this.classRoom = classRoom;
        this.teacher = teacher;
        this.students = new ArrayList<>(students);
    }

    public int getClassId() {
        return classId;
    }

    public String getName() {
        return name;
    }

    public String getClassRoom() { return classRoom; }

    public Teacher getTeacher() {
        return teacher;
    }

    public List<Student> getStudents() {
        return students;
    }
}


