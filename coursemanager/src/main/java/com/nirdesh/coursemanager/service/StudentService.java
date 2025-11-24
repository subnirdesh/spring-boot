package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.entity.Student;

import java.util.List;


public interface StudentService {


    Student createStudent( Student student);
    List<Student> findAll();
    Student findById(Integer id);
    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);
    Student findByEmailAddress(String email);
    Student updateStudent(Integer id,Student newStudent);
    int updateFirstNameById(Integer id, String firstName);
    void deleteStudent(Integer id);
}
