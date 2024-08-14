package models;

public class Student extends Person {
    private String studentId;

    public Student(int personId, String firstname, String lastname, int age, String studentId) {
        super(personId, firstname, lastname, age);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}

