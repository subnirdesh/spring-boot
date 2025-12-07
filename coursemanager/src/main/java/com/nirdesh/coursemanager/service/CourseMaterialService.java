package com.nirdesh.coursemanager.service;


import com.nirdesh.coursemanager.dto.coursematerial.CourseMaterialResponse;
import com.nirdesh.coursemanager.dto.coursematerial.CreateCourseMaterialRequest;
import com.nirdesh.coursemanager.dto.coursematerial.UpdateCourseMaterialRequest;
import com.nirdesh.coursemanager.entity.CourseMaterial;

import java.util.List;

public interface CourseMaterialService {

    CourseMaterialResponse createCourseMaterial(CreateCourseMaterialRequest request);
    CourseMaterialResponse updateCourseMaterial(long id, UpdateCourseMaterialRequest request);
    List<CourseMaterialResponse> getAllCourseMaterial();
    CourseMaterialResponse getCourseMaterial(Long id);

}
