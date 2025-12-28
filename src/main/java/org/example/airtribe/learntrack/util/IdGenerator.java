package org.example.airtribe.learntrack.util;

public class IdGenerator {
    private static int studentIdCounter = 100;
    private static int courseIdCounter = 500;
    private static int enrollmentIdCounter = 1000;

    public static int getNextStudentId() { return ++studentIdCounter; }
    public static int getNextCourseId() { return ++courseIdCounter; }
    public static int getNextEnrollmentId() { return ++enrollmentIdCounter; }
}