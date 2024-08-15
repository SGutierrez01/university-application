package services.implementations;

import models.Student;
import repositories.interfaces.StudentRepository;
import services.interfaces.StudentService;
import java.util.List;

public class StudentServiceImp implements StudentService {

    private StudentRepository studentRepository;

    public StudentServiceImp(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public void addStudent(Student student) {
        studentRepository.add(student);
    }

    @Override
    public void removeStudent(String studentId) {
        Student student = getStudentById(studentId);
        if (student != null) {
            studentRepository.remove(student);
        }
    }

    @Override
    public Student getStudentById(String studentId) {
        return studentRepository.findById(studentId).orElse(null);
    }

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public String formatStudentDetails(Student student) {
        return String.format("Student [ID: %s, Name: %s %s, Age: %d]",
                student.getStudentId(), student.getFirstname(), student.getLastname(), student.getAge());
    }

    @Override
    public void printAllStudents() {
        getAllStudents().forEach(student -> System.out.println(formatStudentDetails(student)));
    }
}
