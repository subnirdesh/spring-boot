package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.coursematerial.CourseMaterialResponse;
import com.nirdesh.coursemanager.dto.coursematerial.CreateCourseMaterialRequest;
import com.nirdesh.coursemanager.dto.coursematerial.UpdateCourseMaterialRequest;
import com.nirdesh.coursemanager.entity.CourseMaterial;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.mapper.CourseMaterialMapper;
import com.nirdesh.coursemanager.repository.CourseMaterialRepository;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.service.CourseMaterialService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CourseMaterialServiceImpl implements CourseMaterialService {
    private final CourseMaterialRepository courseMaterialRepository;
    private final CourseMaterialMapper mapper;
    private final CourseRepository courseRepository;


    @Override
    @Transactional
    public CourseMaterialResponse createCourseMaterial(CreateCourseMaterialRequest request) {
        if (courseMaterialRepository.existsByUrl((request.url()))) {
            throw new ApiException("Course Material already exists with URL: " + request.url(),
                                    HttpStatus.CONFLICT
            );
        }

        if (courseRepository.existsById(request.courseId())) {
            throw new ApiException("Course not found with ID: " + request.courseId(),
                                    HttpStatus.NOT_FOUND);
        }


        CourseMaterial courseMaterial = mapper.toEntity(request);
        courseMaterialRepository.save(courseMaterial);

        return mapper.toResponse(courseMaterial);
    }

    @Override
    @Transactional
    public CourseMaterialResponse updateCourseMaterial(long id, UpdateCourseMaterialRequest request) {

        CourseMaterial existingCourseMaterial = courseMaterialRepository.findById(id)
                .orElseThrow(() -> new ApiException(
                        "Course Material not found with ID: " + id,
                        HttpStatus.NOT_FOUND
                ));

        mapper.updateEntity(request, existingCourseMaterial);

        return mapper.toResponse(courseMaterialRepository.save(existingCourseMaterial));

    }

    @Override
    public List<CourseMaterialResponse> getAllCourseMaterial() {
        return mapper.toResponseList(courseMaterialRepository.findAll());
    }

    @Override
    public CourseMaterialResponse getCourseMaterial(Long id) {

        CourseMaterial courseMaterial = courseMaterialRepository.findById(id)
                .orElseThrow(() -> new ApiException(
                        " Course Material not Found with ID: " + id,
                        HttpStatus.NOT_FOUND
                ));

        return mapper.toResponse(courseMaterial);

    }
}
