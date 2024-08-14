package models;

public abstract class Teacher extends Person {
    private String teacherId;
    private double teacherBaseSalary;

    public Teacher(int personId, String personFirstname, String personLastname, int personAge, String teacherId, double teacherBaseSalary) {
        super(personId, personFirstname, personLastname, personAge);
        this.teacherId = teacherId;
        this.teacherBaseSalary = teacherBaseSalary;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public double getBaseSalary() {
        return teacherBaseSalary;
    }
}

