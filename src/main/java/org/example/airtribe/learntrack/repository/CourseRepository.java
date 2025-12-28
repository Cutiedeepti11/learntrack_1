package org.example.airtribe.learntrack.repository;

import org.example.airtribe.learntrack.entity.Course;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CourseRepository {
    private List<Course> courses = new ArrayList<>();

    public void add(Course course) {
        courses.add(course);
    }

    public List<Course> findAll() {
        return courses;
    }

    public Optional<Course> findById(int id) {
        return courses.stream().filter(c -> c.getId() == id).findFirst();
    }
}