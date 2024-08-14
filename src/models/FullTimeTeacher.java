package models;

public class FullTimeTeacher extends Teacher {
    private int yearsExperiences;

    public FullTimeTeacher(int personId, String personFirstname, String personLastname, int personAge, String teacherId, double teacherBaseSalary, int yearsExperiences) {
        super(personId, personFirstname, personLastname, personAge, teacherId, teacherBaseSalary);
        this.yearsExperiences = yearsExperiences;
    }

    public int getYearsExperiences() {
        return yearsExperiences;
    }
}

