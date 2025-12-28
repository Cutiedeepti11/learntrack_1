package org.example.airtribe.learntrack.service;

import org.example.airtribe.learntrack.entity.Student;
import org.example.airtribe.learntrack.exception.EntityNotFoundException;
import org.example.airtribe.learntrack.exception.InvalidInputException;
import org.example.airtribe.learntrack.repository.StudentRepository;
import org.example.airtribe.learntrack.util.IdGenerator;
import org.example.airtribe.learntrack.util.InputValidator;
import java.util.List;

public class StudentService {
    private StudentRepository repository = new StudentRepository();

    public void registerStudent(String firstName, String lastName, String email, String batch) throws InvalidInputException {
        InputValidator.validateString(firstName, "First Name");
        InputValidator.validateString(email, "Email");
        
        int id = IdGenerator.getNextStudentId();
        Student s = new Student(id, firstName, lastName, email, batch);
        repository.add(s);
        System.out.println("Student registered successfully! ID: " + id);
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }

    public Student getStudentById(int id) throws EntityNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Student with ID " + id + " not found."));
    }
}