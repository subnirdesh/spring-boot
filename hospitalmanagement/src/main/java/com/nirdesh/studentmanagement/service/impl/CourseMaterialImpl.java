package com.nirdesh.studentmanagement.service.impl;

import com.nirdesh.studentmanagement.entity.Course;
import com.nirdesh.studentmanagement.entity.CourseMaterial;
import com.nirdesh.studentmanagement.repository.CourseMaterialRepository;
import com.nirdesh.studentmanagement.repository.CourseRepository;
import com.nirdesh.studentmanagement.service.CourseMaterialService;
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
