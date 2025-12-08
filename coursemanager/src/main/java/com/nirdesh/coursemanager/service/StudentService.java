package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.dto.student.CreateStudentRequest;
import com.nirdesh.coursemanager.dto.student.StudentResponse;
import com.nirdesh.coursemanager.dto.student.UpdateStudentRequest;
import com.nirdesh.coursemanager.entity.Student;

import java.util.List;


public interface StudentService {

    StudentResponse createStudent(CreateStudentRequest request);
    StudentResponse updateStudent(String rollNo, UpdateStudentRequest request);
    StudentResponse getStudent(Long id);
    List<StudentResponse> getAllStudents();




}
