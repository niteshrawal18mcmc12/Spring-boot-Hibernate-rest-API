package com.springrest.springrest.controller;
import java.util.*;

import com.springrest.springrest.entity.Student;

import com.springrest.springrest.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = "*")
public class MyController
{
    @Autowired
    private StudentService studentservice;

    @GetMapping("/home")
    public String home()
    {
        return "This is home";
    }
    //get the courses

    @GetMapping("/students")
    public List<Student> getStudents()
    {
        return this.studentservice.getStudents();
    }

    @GetMapping("/students/{sId}")
    public Student getStudent(@PathVariable String sId)
    {
        return this.studentservice.getStudent(Long.parseLong(sId));
    }

    @PostMapping("/students")
    public Student addStudent(@RequestBody Student student)
    {
        return this.studentservice.addStudent(student);
    }
    @PutMapping("/students")
    public Student updateStudent(@RequestBody Student student)
    {
        return this.studentservice.updateStudent(student);
    }
    @DeleteMapping("/students/{sId}")
    public ResponseEntity<HttpStatus> deleteStudent(@PathVariable String sId)
    {
         try {
             this.studentservice.deleteStudent(Long.parseLong(sId));
             return new ResponseEntity<>(HttpStatus.OK);
         }
         catch (Exception e)
         { return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR); }
    }
}
