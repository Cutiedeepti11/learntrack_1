package org.example.airtribe.learntrack.service;

import org.example.airtribe.learntrack.entity.Enrollment;
import org.example.airtribe.learntrack.repository.EnrollmentRepository;
import org.example.airtribe.learntrack.util.IdGenerator;
import java.util.List;

public class EnrollmentService {
    private EnrollmentRepository repository = new EnrollmentRepository();

    public void enroll(int studentId, int courseId) {
        int id = IdGenerator.getNextEnrollmentId();
        Enrollment e = new Enrollment(id, studentId, courseId);
        repository.add(e);
        System.out.println("Student enrolled! Enrollment ID: " + id);
    }

    public List<Enrollment> getStudentEnrollments(int studentId) {
        return repository.findByStudentId(studentId);
    }
}