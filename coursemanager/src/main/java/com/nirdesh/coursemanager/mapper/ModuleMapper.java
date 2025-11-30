package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.dto.course.UpdateCourseRequest;
import com.nirdesh.coursemanager.dto.module.CreateModuleRequest;
import com.nirdesh.coursemanager.dto.module.ModuleResponse;
import com.nirdesh.coursemanager.dto.module.UpdateModuleRequest;
import com.nirdesh.coursemanager.entity.Course;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ModuleMapper {
    /**
     * Converting Module Entity to ModuleResponseDTO
     * */
    ModuleResponse toResponse(Module module);

    /**
     * Converting   CreateModuleRequest DTO to Module Entity
     * */
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    Module toEntity(CreateModuleRequest request);


    /**
     * Updates existing Module entity with UpdateEntityRequest
     */

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    void updateEntity(UpdateModuleRequest request, @MappingTarget Module module);

    /**
     * Convert a list of entity to list of DTO
     */
    List<ModuleResponse> toReponseList(List<Module> modules);
}
