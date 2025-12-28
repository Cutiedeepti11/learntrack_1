package org.example.airtribe.learntrack.entity;

public class Student extends Person {
    private String batch;

    public Student(int id, String firstName, String lastName, String email, String batch) {
        super(id, firstName, lastName, email);
        this.batch = batch;
    }

    @Override
    public String toString() {
        return super.toString() + ", Batch: " + batch;
    }
}