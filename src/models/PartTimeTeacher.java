package models;

public class PartTimeTeacher extends Teacher {
    private double hoursPerWeek;

    public PartTimeTeacher(int personId, String personFirstname, String personLastname, int personAge, String teacherId, double teacherBaseSalary, double hoursPerWeek) {
        super(personId, personFirstname, personLastname, personAge, teacherId, teacherBaseSalary);
        this.hoursPerWeek = hoursPerWeek;
    }

    public double getHoursPerWeek() {
        return hoursPerWeek;
    }
}

