package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.entity.Course;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import org.mapstruct.*;

import java.util.List;


@Mapper(componentModel = "spring")
public interface CourseMapper {

    /**
     * Converting Course Entity to CourseResponseDTO
     */
    CourseResponse toResponse(Course course);

    /**
     * Converting CreateCourseRequest DTO to Course Entity
     */
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    Course toEntity(CreateCourseRequest request);

    /**
     * Updates existing Course entity with UpdateUserRequest
     */

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    void updateEntity(UpdateCourseRequest request,@MappingTarget Course course);

    /**
     * Convert a list of entity to list of DTO
     */
    List<CourseResponse> toResponseList(List<Course> courses);









}
