package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.module.CreateModuleRequest;
import com.nirdesh.coursemanager.dto.module.ModuleResponse;
import com.nirdesh.coursemanager.dto.module.UpdateModuleRequest;
import com.nirdesh.coursemanager.dto.student.CreateStudentRequest;
import com.nirdesh.coursemanager.dto.student.StudentResponse;
import com.nirdesh.coursemanager.dto.student.UpdateStudentRequest;
import com.nirdesh.coursemanager.entity.Module;
import com.nirdesh.coursemanager.entity.Student;
import org.mapstruct.BeanMapping;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.NullValuePropertyMappingStrategy;

import java.util.List;

public interface StudentMapper {

    /**
     *  Map Student Entity to StudentResponseDTO
     */
    StudentResponse toResponse(Student student);

    /**
     *  Map CreateModuleRequest DTO to Student Entity
     */
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    Student toEntity(CreateStudentRequest request);

    /**
     * Updates existing Student entity with UpdateStudentRequest DTO
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    StudentResponse updateEntity(UpdateStudentRequest request, @MappingTarget Student student);


    /**
     * Converts list of entities to list of response DTO
     */
    List<StudentResponse> toResponseList (List<Student> students);


}
