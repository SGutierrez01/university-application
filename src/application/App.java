package application;

import models.*;
import models.Class;
import repositories.implementations.ClassRepositoryImp;
import repositories.implementations.StudentRepositoryImp;
import repositories.implementations.TeacherRepositoryImp;
import services.implementations.ClassServiceImp;
import services.implementations.StudentServiceImp;
import services.implementations.TeacherServiceImp;
import services.implementations.UniversityServiceImp;
import services.interfaces.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {
    private FullTimeTeacherService fullTimeTeacherService;
    private PartTimeTeacherService partTimeTeacherService;
    private StudentService studentService;
    private ClassService classService;
    private UniversityService universityService;

    public App() {
        TeacherRepositoryImp teacherRepository = new TeacherRepositoryImp();
        StudentRepositoryImp studentRepository = new StudentRepositoryImp();
        ClassRepositoryImp classRepository = new ClassRepositoryImp();

        this.fullTimeTeacherService = new TeacherServiceImp(teacherRepository, teacherRepository);
        this.partTimeTeacherService = new TeacherServiceImp(teacherRepository, teacherRepository);
        this.studentService = new StudentServiceImp(studentRepository);
        this.classService = new ClassServiceImp(classRepository, this.studentService, this.fullTimeTeacherService, this.partTimeTeacherService);
        this.universityService = new UniversityServiceImp(fullTimeTeacherService, partTimeTeacherService, studentService, classService);

        initializeData();
    }

    private void initializeData() {
        FullTimeTeacher fullTimeTeacher1 = new FullTimeTeacher(1001, "John", "Doe", 40, "FT1", 5000, 6);
        FullTimeTeacher fullTimeTeacher2 = new FullTimeTeacher(1002, "Jane", "Smith", 35, "FT2", 5000, 10);

        PartTimeTeacher partTimeTeacher1 = new PartTimeTeacher(1101, "Michael", "Johnson", 45, "PT1", 1000, 10);
        PartTimeTeacher partTimeTeacher2 = new PartTimeTeacher(1101, "Sarah", "Williams", 32, "PT2", 1000, 8);

        fullTimeTeacherService.addFullTimeTeacher(fullTimeTeacher1);
        fullTimeTeacherService.addFullTimeTeacher(fullTimeTeacher2);
        partTimeTeacherService.addPartTimeTeacher(partTimeTeacher1);
        partTimeTeacherService.addPartTimeTeacher(partTimeTeacher2);

        Student student1 = new Student(1, "Alice", "Brown", 20, "ST1");
        Student student2 = new Student(2, "Bob", "Davis", 21, "ST2");
        Student student3 = new Student(3, "Charlie", "Evans", 22, "ST3");
        Student student4 = new Student(4, "David", "Franklin", 23, "ST4");
        Student student5 = new Student(5, "Eve", "Garcia", 19, "ST5");
        Student student6 = new Student(6, "Frank", "Harris", 20, "ST6");

        studentService.addStudent(student1);
        studentService.addStudent(student2);
        studentService.addStudent(student3);
        studentService.addStudent(student4);
        studentService.addStudent(student5);
        studentService.addStudent(student6);

        Class class1 = new Class(1, "Math 101", "Building A",fullTimeTeacher1, List.of(student1, student2, student3));
        Class class2 = new Class(2, "Physics 101", "Building B",fullTimeTeacher2, List.of(student4, student5));
        Class class3 = new Class(3, "Chemistry 101", "Building C",partTimeTeacher1, List.of(student1, student6));
        Class class4 = new Class(4, "History 101", "Building D",partTimeTeacher2, List.of(student2, student3, student4));

        classService.addClass(class1);
        classService.addClass(class2);
        classService.addClass(class3);
        classService.addClass(class4);
    }

    public void run() {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        do {
            showMenu();
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    printAllProfessors();
                    break;
                case 2:
                    printAllClasses(scanner);
                    break;
                case 3:
                    createNewStudentAndAddToClass(scanner);
                    break;
                case 4:
                    createNewClass(scanner);
                    break;
                case 5:
                    listClassesByStudentId(scanner);
                    break;
                case 6:
                    running = false;
                    System.out.println("Exiting the program. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        } while (running);

        scanner.close();
    }

    private void showMenu() {
        System.out.println("\n--- University Management System ---");
        System.out.println("1. Print all professors with their data");
        System.out.println("2. Print all classes and select a class to view its details");
        System.out.println("3. Create a new student and add to an existing class");
        System.out.println("4. Create a new class with an existing teacher and students");
        System.out.println("5. List all classes in which a given student is included");
        System.out.println("6. Exit");
        System.out.print("Please select an option: ");
    }

    private void printAllProfessors() {
        System.out.println("\n--- All Professors ---");
        universityService.printAllTeachers();
    }

    private void printAllClasses(Scanner scanner) {
        System.out.println("\n--- All Classes ---");
        universityService.printAllClasses();

        System.out.print("\nEnter the class ID to view details: ");
        int classId = Integer.parseInt(scanner.nextLine());
        Class selectedClass = classService.getClassById(classId);
        if (selectedClass != null) {
            classService.printClassDetails(selectedClass);
        } else {
            System.out.println("Class not found.");
        }
    }

    private void createNewStudentAndAddToClass(Scanner scanner) {
        System.out.print("Enter student first name: ");
        String firstName = scanner.nextLine();
        System.out.print("Enter student last name: ");
        String lastName = scanner.nextLine();
        System.out.print("Enter student age: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.print("Enter student ID: ");
        String studentId = scanner.nextLine();

        Student newStudent = new Student(studentService.getAllStudents().size() + 1, firstName, lastName, age, studentId);
        studentService.addStudent(newStudent);

        System.out.println("\n--- All Classes ---");
        universityService.printAllClasses();
        System.out.print("\nEnter the class ID to add the student to: ");
        int classId = Integer.parseInt(scanner.nextLine());
        Class selectedClass = classService.getClassById(classId);
        if (selectedClass != null) {
            classService.addStudentToClass(classId, newStudent);
            System.out.println("\nStudent added to the class.");
        } else {
            System.out.println("Class not found.");
        }
    }

    private void createNewClass(Scanner scanner) {
        System.out.print("Enter class name: ");
        String className = scanner.nextLine();
        System.out.println("Enter class location");
        String classRoom = scanner.nextLine();
        System.out.println("\n--- All Professors ---");
        universityService.printAllTeachers();
        System.out.print("Enter the ID of the teacher for this class: ");
        String teacherId = scanner.nextLine();
        Teacher selectedTeacher = fullTimeTeacherService.getFullTimeTeacherById(teacherId);
        if (selectedTeacher == null) {
            selectedTeacher = partTimeTeacherService.getPartTimeTeacherById(teacherId);
        }
        if (selectedTeacher == null) {
            System.out.println("Teacher not found.");
            return;
        }

        System.out.println("\n--- All Students ---");
        universityService.printAllStudents();
        System.out.print("Enter the student IDs to add to the class (comma separated): ");
        String[] studentIds = scanner.nextLine().split(",");
        List<Student> selectedStudents = new ArrayList<>();
        for (String id : studentIds) {
            Student student = studentService.getStudentById(id.trim());
            if (student != null) {
                selectedStudents.add(student);
            }
        }

        Class newClass = new Class(classService.getAllClasses().size() + 1, className, classRoom,selectedTeacher, selectedStudents);
        classService.addClass(newClass);
        System.out.println("Class created successfully.");
    }

    private void listClassesByStudentId(Scanner scanner) {
        System.out.print("Enter the student ID to search for classes: ");
        String studentId = scanner.nextLine();
        Student student = studentService.getStudentById(studentId);
        if (student != null) {
            System.out.println("\n--- Classes for Student ID " + studentId + " ---");
            universityService.getAllClasses().stream()
                    .filter(c -> c.getStudents().contains(student))
                    .forEach(classService::printClassDetails);
        } else {
            System.out.println("Student not found.");
        }
    }
}

