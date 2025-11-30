package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.dto.coursematerial.CourseMaterialResponse;
import com.nirdesh.coursemanager.dto.coursematerial.CreateCourseMaterialRequest;
import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.entity.CourseMaterial;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CourseMaterialMapper {


    CourseMaterialResponse toResponse(CourseMaterial courseMaterial);



    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target="status",ignore = true)
    Course toEntity(CreateCourseMaterialRequest request);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target="status",ignore = true)
    CourseMaterialResponse updateEntity(UpdateCourseRequest request, @MappingTarget CourseMaterial courseMaterial);


    List<CourseMaterial> toResponseList(List<CourseMaterial> courses );




}
