package com.example.assignment2;

import java.util.ArrayList;
import java.util.List;

public class StudentRepository {
    private static StudentRepository instance = null;
    private List<Student> students = new ArrayList<>();

    private StudentRepository(){
        Student student =new Student();
        student.name="jp";
        student.id=1;
        student.password="1";
        this.students.add(student);

    }
    public static StudentRepository getInstance() {
        if (instance == null) {
            instance = new StudentRepository();
        }
        return instance;
    }
    public void addStudent(Student student) {
        this.students.add(student);
    }

    public List<Student> getStudents() {
        return this.students;
    }
}
