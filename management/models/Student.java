package com.management.models;

public abstract class Student {
    private String name;
    private int id;

    protected String[] courses;
    protected double[] grades;
    protected int courseCount;

    public Student(String name, int id) {
        this.name = name;
        this.id = id;
        this.courses = new String[5];
        this.grades = new double[5];
        this.courseCount = 0;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public abstract void displayDetails();

    public void enrollCourse(String course) {
        if (course == null || course.trim().isEmpty()) {
            System.out.println("Invalid course name");
            return;
        }
        if (courseCount < courses.length) {
            courses[courseCount++] = course;
            System.out.println(name + " enrolled in " + course + "!");
        } else {
            System.out.println("Cannot enroll in more courses. Limit reached.");
        }
    }

    public void dropCourse(String course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                System.out.println("Dropped course: " + course + " for " + name);
                courses[i] = courses[--courseCount];
                grades[i] = grades[courseCount];
                courses[courseCount] = null;
                grades[courseCount] = 0.0;
                return;
            }
        }
        System.out.println("Course not found for this student.");
    }

    public void addGrade(String course, double grade) {
        if (grade < 0.0 || grade > 100.0) {
            System.out.println("Grade must be between 0 and 100");
            return;
        }
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                grades[i] = grade;
                System.out.println("Updated grade: " + grade + " for course " + course);
                return;
            }
        }
        System.out.println("Course not found. Cannot add grade.");
    }

    public double calculateAverage() {
        if (courseCount == 0) return 0.0;

        double sum = 0.0;
        for (int i = 0; i < courseCount; i++) {
            sum += grades[i];
        }
        return sum / courseCount;
    }

    public boolean isEnrolledIn(String course) {
        for (int i = 0; i < courseCount; i++) {
            if (courses[i].equalsIgnoreCase(course)) {
                return true;
            }
        }
        return false;
    }
}
