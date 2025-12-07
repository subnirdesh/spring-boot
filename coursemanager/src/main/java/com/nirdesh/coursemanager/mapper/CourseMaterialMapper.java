package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.coursematerial.CourseMaterialResponse;
import com.nirdesh.coursemanager.dto.coursematerial.CreateCourseMaterialRequest;
import com.nirdesh.coursemanager.dto.coursematerial.UpdateCourseMaterialRequest;
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
    CourseMaterial toEntity(CreateCourseMaterialRequest request);


    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target = "updatedAt",ignore = true)
    @Mapping(target="status",ignore = true)
    void updateEntity(UpdateCourseMaterialRequest request, @MappingTarget CourseMaterial courseMaterial);


    List<CourseMaterialResponse> toResponseList(List<CourseMaterial> courseMaterials );




}
