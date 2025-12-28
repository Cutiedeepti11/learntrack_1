package org.example.airtribe.learntrack.repository;

import org.example.airtribe.learntrack.entity.Student;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StudentRepository {
    private List<Student> students = new ArrayList<>();

    public void add(Student student) {
        students.add(student);
    }

    public List<Student> findAll() {
        return students;
    }

    public Optional<Student> findById(int id) {
        return students.stream().filter(s -> s.getId() == id).findFirst();
    }
}