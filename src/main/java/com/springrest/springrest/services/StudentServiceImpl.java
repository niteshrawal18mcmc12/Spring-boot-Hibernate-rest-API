package com.springrest.springrest.services;

import com.springrest.springrest.dao.StudentDao;
import com.springrest.springrest.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService{
//    List<Course> list;
    @Autowired
    private StudentDao studentDao;
    public StudentServiceImpl()
    {
    }

    @Override
    public List<Student> getStudents() {
        return studentDao.findAll();
    }

    @Override
    public Student getStudent(long sId) {

        return studentDao.findById(sId).get();
    }

    @Override
    public Student addStudent(Student student) {

        studentDao.save(student);
        return student;
    }

    @Override
    public Student updateStudent(Student student) {
        studentDao.save(student);
        return student;
    }

    @Override
    public void deleteStudent(long sId) {

        Student one = studentDao.getOne(sId);
        studentDao.delete(one);

    }
}
