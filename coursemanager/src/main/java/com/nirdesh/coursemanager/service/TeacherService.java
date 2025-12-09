package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.dto.teacher.CreateTeacherRequest;
import com.nirdesh.coursemanager.dto.teacher.TeacherResponse;
import com.nirdesh.coursemanager.dto.teacher.UpdateTeacherRequest;
import com.nirdesh.coursemanager.entity.Teacher;

import java.util.List;

public interface TeacherService {

    TeacherResponse createTeacher(CreateTeacherRequest request);
    TeacherResponse updateTeacher(Long id, UpdateTeacherRequest request);
    TeacherResponse getTeacher(Long id);
    List<TeacherResponse> getAllTeachers();
}
