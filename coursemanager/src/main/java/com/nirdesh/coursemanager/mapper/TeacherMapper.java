package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.teacher.CreateTeacherRequest;
import com.nirdesh.coursemanager.dto.teacher.TeacherResponse;
import com.nirdesh.coursemanager.dto.teacher.UpdateTeacherRequest;
import com.nirdesh.coursemanager.entity.Teacher;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TeacherMapper {


    /**
     * Maps Teacher entity to TeacherResponseDTO
     */
    TeacherResponse toResponse(Teacher teacher);


    /**
     * Map CreateTeacherRequest DTO to actual Teacher entity
     */
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    Teacher toEntity(CreateTeacherRequest request);

    /**
     * Update teacher entity with UpdateTeacherRequest DTO
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    void updateEntity(UpdateTeacherRequest request, @MappingTarget Teacher teacher);

    /**
     * Map list of entity to list of DTO
     */
    List<TeacherResponse> toReponseList(List<Teacher> teachers);






}
