package models;

public class PartTimeTeacher extends Teacher {
    private double hoursPerWeek;

    public PartTimeTeacher(int personId, String firstname, String lastname, int age, String teacherId, double baseSalary, double hoursPerWeek) {
        super(personId, firstname, lastname, age, teacherId, baseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }
}

