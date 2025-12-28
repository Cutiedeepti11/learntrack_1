package org.example.airtribe.learntrack;

import org.example.airtribe.learntrack.constants.AppConstants;
import org.example.airtribe.learntrack.constants.MenuOptions;
import org.example.airtribe.learntrack.service.*;
import org.example.airtribe.learntrack.exception.*;
import java.util.Scanner;

public class Main {
    private static StudentService studentService = new StudentService();
    private static CourseService courseService = new CourseService();
    private static EnrollmentService enrollmentService = new EnrollmentService();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to " + AppConstants.APP_NAME);
        boolean running = true;

        while (running) {
            System.out.println("\n--- MAIN MENU ---");
            System.out.println("1. Student Management");
            System.out.println("2. Course Management");
            System.out.println("3. Enrollment Management");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1: handleStudentMenu(); break;
                case 2: handleCourseMenu(); break;
                case 3: handleEnrollmentMenu(); break;
                case 4:
                    running = false;
                    System.out.println(AppConstants.EXIT_MESSAGE);
                    break;
                default: System.out.println("Invalid choice.");
            }
        }
    }

    private static void handleStudentMenu() {
        System.out.println("\n-- Student Menu --");
        System.out.println(MenuOptions.ADD_STUDENT + ". Add Student");
        System.out.println(MenuOptions.VIEW_STUDENTS + ". View Students");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        try {
            if (choice == MenuOptions.ADD_STUDENT) {
                System.out.print("First Name: "); String fn = scanner.nextLine();
                System.out.print("Last Name: "); String ln = scanner.nextLine();
                System.out.print("Email: "); String em = scanner.nextLine();
                System.out.print("Batch: "); String batch = scanner.nextLine();
                studentService.registerStudent(fn, ln, em, batch);
            } else if (choice == MenuOptions.VIEW_STUDENTS) {
                studentService.getAllStudents().forEach(System.out::println);
            }
        } catch (InvalidInputException e) {
            System.out.println("Validation Error: " + e.getMessage());
        }
    }

    private static void handleCourseMenu() {
        System.out.println("\n-- Course Menu --");
        System.out.println(MenuOptions.ADD_COURSE + ". Add Course");
        System.out.println(MenuOptions.VIEW_COURSES + ". View Courses");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == MenuOptions.ADD_COURSE) {
            System.out.print("Course Name: "); String name = scanner.nextLine();
            System.out.print("Description: "); String desc = scanner.nextLine();
            System.out.print("Duration (Weeks): "); int weeks = scanner.nextInt();
            courseService.createCourse(name, desc, weeks);
        } else if (choice == MenuOptions.VIEW_COURSES) {
            courseService.getAllCourses().forEach(System.out::println);
        }
    }

    private static void handleEnrollmentMenu() {
        System.out.println("\n-- Enrollment Menu --");
        System.out.println(MenuOptions.ENROLL_STUDENT + ". Enroll Student");
        System.out.println(MenuOptions.VIEW_ENROLLMENTS + ". View Student Enrollments");
        System.out.print("Choice: ");
        int choice = scanner.nextInt();
        scanner.nextLine();

        if (choice == MenuOptions.ENROLL_STUDENT) {
            try {
                System.out.print("Student ID: "); int sid = scanner.nextInt();
                System.out.print("Course ID: "); int cid = scanner.nextInt();

                // Check existence
                studentService.getStudentById(sid);
                courseService.getCourseById(cid);

                enrollmentService.enroll(sid, cid);
            } catch (EntityNotFoundException e) {
                System.out.println("Error: " + e.getMessage());
            }
        } else if (choice == MenuOptions.VIEW_ENROLLMENTS) {
            System.out.print("Enter Student ID: "); int sid = scanner.nextInt();
            enrollmentService.getStudentEnrollments(sid).forEach(System.out::println);
        }
    }
}