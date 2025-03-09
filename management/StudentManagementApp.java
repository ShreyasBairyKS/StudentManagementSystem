package com.management;

import com.management.models.*;
import com.management.services.*;

import java.util.Scanner;

public class StudentManagementApp {
    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        Scanner scanner = new Scanner(System.in);

        String command;
        do {
            System.out.println("\n========== MENU ==========");
            System.out.println("1. Add Student");
            System.out.println("2. Remove Student");
            System.out.println("3. Display All Students");
            System.out.println("4. Display Student Details");
            System.out.println("5. Enroll in Course");
            System.out.println("6. Drop a Course");
            System.out.println("7. Add Grade");
            System.out.println("8. Update Student Name");
            System.out.println("9. Display Class Average");
            System.out.println("10. Sort Students by Name");
            System.out.println("11. Sort Students by ID");
            System.out.println("12. Exit");
            System.out.println("==========================");
            System.out.print("Enter your choice: ");
            command = scanner.nextLine();

            try {
                switch (command) {
                    case "1":
                        System.out.print("Enter student name: ");
                        String name = scanner.nextLine();
                        System.out.print("Enter student ID: ");
                        int id = Integer.parseInt(scanner.nextLine());
                        sms.addStudent(new UndergraduateStudent(name, id));
                        break;
                    case "2":
                        System.out.print("Enter student ID to remove: ");
                        id = Integer.parseInt(scanner.nextLine());
                        sms.removeStudent(id);
                        break;
                    case "3":
                        sms.displayAllStudents();
                        break;
                    case "4":
                        System.out.print("Enter student ID to view details: ");
                        id = Integer.parseInt(scanner.nextLine());
                        sms.displayStudentDetails(id);
                        break;
                    case "5":
                        System.out.print("Enter student ID to enroll: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter course name: ");
                        String course = scanner.nextLine();
                        Student student = sms.findStudent(id);
                        if (student != null) {
                            student.enrollCourse(course);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case "6":
                        System.out.print("Enter student ID to drop a course: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter course name: ");
                        course = scanner.nextLine();
                        student = sms.findStudent(id);
                        if (student != null) {
                            student.dropCourse(course);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case "7":
                        System.out.print("Enter student ID to add grade: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter course name: ");
                        course = scanner.nextLine();
                        System.out.print("Enter grade: ");
                        double grade = Double.parseDouble(scanner.nextLine());
                        student = sms.findStudent(id);
                        if (student != null) {
                            student.addGrade(course, grade);
                        } else {
                            System.out.println("Student not found.");
                        }
                        break;
                    case "8":
                        System.out.print("Enter student ID to update name: ");
                        id = Integer.parseInt(scanner.nextLine());
                        System.out.print("Enter new name: ");
                        String newName = scanner.nextLine();
                        sms.updateStudentName(id, newName);
                        break;
                    case "9":
                        sms.displayClassAverage();
                        break;
                    case "10":
                        sms.sortStudentsByName();
                        sms.displayAllStudents();
                        break;
                    case "11":
                        sms.sortStudentsById();
                        sms.displayAllStudents();
                        break;
                    case "12":
                        System.out.println("Exiting the system. Goodbye!");
                        break;
                    default:
                        System.out.println("Invalid choice. Try again.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
            }
        } while (!command.equals("12"));

        scanner.close();
    }
}