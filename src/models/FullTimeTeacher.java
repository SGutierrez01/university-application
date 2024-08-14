package models;

public class FullTimeTeacher extends Teacher {
    private int yearsExperiences;

    public FullTimeTeacher(int personId, String firstname, String lastname, int age, String teacherId, double baseSalary, int yearsExperiences) {
        super(personId, firstname, lastname, age, teacherId, baseSalary);
        this.yearsExperiences = yearsExperiences;
    }

    public int getYearsExperiences() {
        return yearsExperiences;
    }
}

