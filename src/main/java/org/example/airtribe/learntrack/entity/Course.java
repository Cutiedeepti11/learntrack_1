package org.example.airtribe.learntrack.entity;


import org.example.airtribe.learntrack.enums.CourseStatus;

public class Course {
    private int id;
    private String courseName;
    private String description;
    private int durationInWeeks;
    private CourseStatus status;

    public Course(int id, String courseName, String description, int durationInWeeks) {
        this.id = id;
        this.courseName = courseName;
        this.description = description;
        this.durationInWeeks = durationInWeeks;
        this.status = CourseStatus.ACTIVE;
    }

    public int getId() { return id; }
    public String getCourseName() { return courseName; }
    
    @Override
    public String toString() {
        return "ID: " + id + " | " + courseName + " | " + durationInWeeks + " weeks | " + status;
    }
}