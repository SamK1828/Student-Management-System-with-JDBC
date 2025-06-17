package controller;

import model.Student;
import service.StudentService;

import java.util.List;
import java.util.Scanner;

public class StudentController {
    private final StudentService service = new StudentService();
    private final Scanner sc = new Scanner(System.in);

    public void start() {
        while (true) {
        	System.out.println("\n------------------------------------");
            System.out.println("---- Student Management Portal----");
            System.out.println("1. Add Student");
            System.out.println("2. Update Student");
            System.out.println("3. Delete Student");
            System.out.println("4. View Student By ID");
            System.out.println("5. View All Students");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");
            int ch = sc.nextInt();
            sc.nextLine();

            switch (ch) {
                case 1 -> addStudent();
                case 2 -> updateStudent();
                case 3 -> deleteStudent();
                case 4 -> viewStudentById();
                case 5 -> viewAllStudents();
                case 6 -> {
                    System.out.println("Exiting...");
                    return;
                }
                default -> System.out.println("Invalid choice!");
            }
        }
    }

    private void addStudent() {
        System.out.print("Name: ");
        String name = sc.nextLine();
        System.out.print("Email: ");
        String email = sc.nextLine();
        System.out.print("Course: ");
        String course = sc.nextLine();

        Student student = new Student(0, name, email, course);
        if (service.addStudent(student)) {
            System.out.println("Student added successfully!");
        } else {
            System.out.println("Failed to add student.");
        }
    }

    private void updateStudent() {
        System.out.print("Enter ID to update: ");
        int id = sc.nextInt();
        sc.nextLine();

        Student student = service.getStudentById(id);
        if (student == null) {
            System.out.println("Student not found!");
            return;
        }

        System.out.print("New Name: ");
        student.setName(sc.nextLine());
        System.out.print("New Email: ");
        student.setEmail(sc.nextLine());
        System.out.print("New Course: ");
        student.setCourse(sc.nextLine());

        if (service.updateStudent(student)) {
            System.out.println("Student updated.");
        } else {
            System.out.println("Update failed.");
        }
    }

    private void deleteStudent() {
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();
        if (service.deleteStudent(id)) {
            System.out.println("Student deleted.");
        } else {
            System.out.println("Delete failed.");
        }
    }

    private void viewStudentById() {
        System.out.print("Enter ID to view: ");
        int id = sc.nextInt();
        Student student = service.getStudentById(id);
        if (student != null) {
            System.out.println(student);
        } else {
            System.out.println("Student not found.");
        }
    }

    private void viewAllStudents() {
        List<Student> list = service.getAllStudents();
        if (list.isEmpty()) {
            System.out.println("No students found.");
        } else {
            list.forEach(System.out::println);
        }
    }
}
