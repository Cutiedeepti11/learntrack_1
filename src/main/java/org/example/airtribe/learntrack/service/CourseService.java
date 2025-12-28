package org.example.airtribe.learntrack.service;

import org.example.airtribe.learntrack.entity.Course;
import org.example.airtribe.learntrack.exception.EntityNotFoundException;
import org.example.airtribe.learntrack.repository.CourseRepository;
import org.example.airtribe.learntrack.util.IdGenerator;
import java.util.List;

public class CourseService {
    private CourseRepository repository = new CourseRepository();

    public void createCourse(String name, String desc, int weeks) {
        int id = IdGenerator.getNextCourseId();
        Course c = new Course(id, name, desc, weeks);
        repository.add(c);
        System.out.println("Course created! ID: " + id);
    }

    public List<Course> getAllCourses() {
        return repository.findAll();
    }

    public Course getCourseById(int id) throws EntityNotFoundException {
        return repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Course with ID " + id + " not found."));
    }
}