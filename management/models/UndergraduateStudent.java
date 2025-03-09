package com.management.models;

public class UndergraduateStudent extends Student {

    public UndergraduateStudent(String name, int id) {
        super(name, id);
    }

    @Override
    public void displayDetails() {
        System.out.println("Student ID: " + getId());
        System.out.println("Name: " + getName());
        System.out.print("Courses Enrolled: ");
        if (courseCount == 0) {
            System.out.println("None");
        } else {
            for (int i = 0; i < courseCount; i++) {
                System.out.print(courses[i] + " (Grade: " + grades[i] + ")");
                if (i < courseCount - 1) System.out.print(", ");
            }
            System.out.println();
        }
        System.out.println("--------------------------");
    }
}
