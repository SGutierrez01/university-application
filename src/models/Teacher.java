package models;

public abstract class Teacher extends Person {
    private String teacherId;
    private double baseSalary;

    public Teacher(int personId, String firstname, String lastname, int age, String teacherId, double baseSalary) {
        super(personId, firstname, lastname, age);
        this.teacherId = teacherId;
        this.baseSalary = baseSalary;
    }

    public String getTeacherId() {
        return teacherId;
    }

    public double getBaseSalary() {
        return baseSalary;
    }
}

