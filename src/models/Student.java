package models;

public class Student extends Person {
    private String studentId;

    public Student(int personId, String personFirstname, String personLastname, int personAge, String studentId) {
        super(personId, personFirstname, personLastname, personAge);
        this.studentId = studentId;
    }

    public String getStudentId() {
        return studentId;
    }
}

