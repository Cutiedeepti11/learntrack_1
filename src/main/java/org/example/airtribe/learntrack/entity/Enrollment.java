package org.example.airtribe.learntrack.entity;


import org.example.airtribe.learntrack.enums.EnrollmentStatus;

import java.time.LocalDate;

public class Enrollment {
    private int id;
    private int studentId;
    private int courseId;
    private LocalDate enrollmentDate;
    private EnrollmentStatus status;

    public Enrollment(int id, int studentId, int courseId) {
        this.id = id;
        this.studentId = studentId;
        this.courseId = courseId;
        this.enrollmentDate = LocalDate.now();
        this.status = EnrollmentStatus.ACTIVE;
    }

    public int getStudentId() { return studentId; }
    
    @Override
    public String toString() {
        return "Enrollment ID: " + id + " | Student ID: " + studentId + " | Course ID: " + courseId + " | Status: " + status;
    }
}