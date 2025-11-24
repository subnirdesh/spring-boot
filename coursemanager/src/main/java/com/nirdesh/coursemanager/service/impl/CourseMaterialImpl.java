package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.entity.CourseMaterial;
import com.nirdesh.coursemanager.repository.CourseMaterialRepository;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.service.CourseMaterialService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseMaterialImpl implements CourseMaterialService {

    private final CourseMaterialRepository courseMaterialRepository;
    private final CourseRepository courseRepository;

    public CourseMaterialImpl(CourseMaterialRepository courseMaterialRepository,  CourseRepository courseRepository1) {
        this.courseMaterialRepository = courseMaterialRepository;
        this.courseRepository = courseRepository1;
    }

    @Override
    public CourseMaterial createCourseMaterial(Integer courseId,String url) {
        Course course=courseRepository.findById(courseId).orElse(null);

        CourseMaterial courseMaterial =new CourseMaterial();
        courseMaterial.setUrl(url);
        courseMaterial.setCourse(course);

        return courseMaterialRepository.save(courseMaterial);


    }

    @Override
    public List<CourseMaterial> getAllCourseMaterial() {
        return courseMaterialRepository.findAll();
    }
}
