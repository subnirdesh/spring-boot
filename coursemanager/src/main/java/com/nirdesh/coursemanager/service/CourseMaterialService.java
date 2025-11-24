package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.entity.CourseMaterial;

import java.util.List;

public interface CourseMaterialService {

    CourseMaterial createCourseMaterial(Integer courseId,String url);
    List<CourseMaterial> getAllCourseMaterial();
}
