package com.springrest.springrest.services;

import com.springrest.springrest.entity.Student;

import java.util.List;

public interface StudentService {
    public List<Student> getStudents();
    public Student getStudent(long sId);
    public Student addStudent(Student student);
    public Student updateStudent(Student student);
    public void deleteStudent(long sId);
}
