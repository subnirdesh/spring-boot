package com.nirdesh.studentmanagement.service;

import com.nirdesh.studentmanagement.entity.CourseMaterial;

import java.util.List;

public interface CourseMaterialService {

    CourseMaterial createCourseMaterial(Integer courseId,String url);
    List<CourseMaterial> getAllCourseMaterial();
}
