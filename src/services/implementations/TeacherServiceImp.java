package services.implementations;

import models.FullTimeTeacher;
import models.PartTimeTeacher;
import repositories.interfaces.FullTimeTeacherRepository;
import repositories.interfaces.PartTimeTeacherRepository;
import services.interfaces.FullTimeTeacherService;
import services.interfaces.PartTimeTeacherService;
import java.util.List;

public class TeacherServiceImp implements FullTimeTeacherService, PartTimeTeacherService {

    private FullTimeTeacherRepository fullTimeTeacherRepository;
    private PartTimeTeacherRepository partTimeTeacherRepository;

    public TeacherServiceImp(FullTimeTeacherRepository fullTimeTeacherRepository,
                             PartTimeTeacherRepository partTimeTeacherRepository) {
        this.fullTimeTeacherRepository = fullTimeTeacherRepository;
        this.partTimeTeacherRepository = partTimeTeacherRepository;
    }

    @Override
    public double calculateSalary(FullTimeTeacher teacher) {
        return teacher.getBaseSalary() * 1.1 * teacher.getYearsExperiences();
    }

    @Override
    public String formatTeacherDetails(FullTimeTeacher teacher) {
        return String.format("FullTimeTeacher [ID: %s, Name: %s %s, Age: %d, Salary: %.2f]",
                teacher.getTeacherId(), teacher.getFirstname(), teacher.getLastname(),
                teacher.getAge(), calculateSalary(teacher));
    }

    @Override
    public void addFullTimeTeacher(FullTimeTeacher teacher) {
        fullTimeTeacherRepository.add(teacher);
    }

    @Override
    public void removeFullTimeTeacher(String teacherId) {
        FullTimeTeacher teacher = getFullTimeTeacherById(teacherId);
        if (teacher != null) {
            fullTimeTeacherRepository.remove(teacher);
        }
    }

    @Override
    public FullTimeTeacher getFullTimeTeacherById(String teacherId) {
        return fullTimeTeacherRepository.findFullTimeTeacherById(teacherId).orElse(null);
    }

    @Override
    public List<FullTimeTeacher> getAllFullTimeTeachers() {
        return fullTimeTeacherRepository.findAllFullTimeTeachers();
    }

    @Override
    public double calculateSalary(PartTimeTeacher teacher) {
        return teacher.getBaseSalary() * teacher.getHoursPerWeek();
    }

    @Override
    public String formatTeacherDetails(PartTimeTeacher teacher) {
        return String.format("PartTimeTeacher [ID: %s, Name: %s %s, Age: %d, Salary: %.2f]",
                teacher.getTeacherId(), teacher.getFirstname(), teacher.getLastname(),
                teacher.getAge(), calculateSalary(teacher));
    }

    @Override
    public void addPartTimeTeacher(PartTimeTeacher teacher) {
        partTimeTeacherRepository.add(teacher);
    }

    @Override
    public void removePartTimeTeacher(String teacherId) {
        PartTimeTeacher teacher = getPartTimeTeacherById(teacherId);
        if (teacher != null) {
            partTimeTeacherRepository.remove(teacher);
        }
    }

    @Override
    public PartTimeTeacher getPartTimeTeacherById(String teacherId) {
        return partTimeTeacherRepository.findPartTimeTeacherById(teacherId).orElse(null);
    }

    @Override
    public List<PartTimeTeacher> getAllPartTimeTeachers() {
        return partTimeTeacherRepository.findAllPartTimeTeachers();
    }
}

