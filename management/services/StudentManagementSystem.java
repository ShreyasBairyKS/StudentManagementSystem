package com.management.services;

import com.management.models.*;

public class StudentManagementSystem {
    private Student[] students;
    private int studentCount;

    public StudentManagementSystem() {
        this.students = new Student[100];
        this.studentCount = 0;
    }

    public void addStudent(Student student) {
        // Check for duplicate ID
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == student.getId()) {
                System.out.println("Student ID already exists.");
                return;
            }
        }
        if (studentCount < students.length) {
            students[studentCount++] = student;
            System.out.println("Student added: " + student.getName());
        } else {
            System.out.println("Student limit reached.");
        }
    }

    public void updateStudentName(int id, String newName) {
        Student student = findStudent(id);
        if (student != null) {
            student.setName(newName);
            System.out.println("Updated name to " + newName);
        } else {
            System.out.println("Student not found.");
        }
    }

    public void removeStudent(int id) {
        for (int i = 0; i < studentCount; i++) {
            if (students[i].getId() == id) {
                System.out.println("Removing student: " + students[i].getName());
                students[i] = students[--studentCount];
                students[studentCount] = null;
                return;
            }
        }
        System.out.println("Student not found.");
    }

    public void displayStudentDetails(int id) {
        Student student = findStudent(id);
        if (student != null) {
            student.displayDetails();
        } else {
            System.out.println("Student not found.");
        }
    }

    public void displayAllStudents() {
        if (studentCount == 0) {
            System.out.println("No students available.");
            return;
        }
        System.out.println("========== All Students ==========");
        for (int i = 0; i < studentCount; i++) {
            students[i].displayDetails();
        }
        System.out.println("==================================");
    }

    public void displayClassAverage() {
        if (studentCount == 0) {
            System.out.println("No students to calculate average.");
            return;
        }
        double totalAverage = 0.0;
        for (int i = 0; i < studentCount; i++) {
            totalAverage += students[i].calculateAverage();
        }
        System.out.printf("Class Average Grade: %.2f%n", (totalAverage / studentCount));
    }

    public void sortStudentsByName() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = i + 1; j < studentCount; j++) {
                if (students[i].getName().compareToIgnoreCase(students[j].getName()) > 0) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Students sorted by name.");
    }

    public void sortStudentsById() {
        for (int i = 0; i < studentCount - 1; i++) {
            for (int j = i + 1; j < studentCount; j++) {
                if (students[i].getId() > students[j].getId()) {
                    Student temp = students[i];
                    students[i] = students[j];
                    students[j] = temp;
                }
            }
        }
        System.out.println("Students sorted by ID.");
    }

    public Student findStudent(int id) {
        for (Student student : students) {
            if (student != null && student.getId() == id) {
                return student;
            }
        }
        return null;
    }
}
