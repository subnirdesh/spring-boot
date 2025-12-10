package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.student.CreateStudentRequest;
import com.nirdesh.coursemanager.dto.student.StudentResponse;
import com.nirdesh.coursemanager.dto.student.UpdateStudentRequest;
import com.nirdesh.coursemanager.entity.Course;
import com.nirdesh.coursemanager.entity.Student;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.repository.CourseRepository;
import org.mapstruct.*;
import org.springframework.http.HttpStatus;


import java.util.List;

@Mapper(componentModel = "spring")
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
    @Mapping(target = "course", source = "courseId", qualifiedByName = "mapCourse")
    Student toEntity(CreateStudentRequest request,@Context CourseRepository courseRepository);

    /**
     * Updates existing Student entity with UpdateStudentRequest DTO
     */
    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "id",ignore=true)
    @Mapping(target = "createdAt",ignore = true)
    @Mapping(target="updatedAt",ignore=true)
    @Mapping(target="status",ignore = true)
    void updateEntity(UpdateStudentRequest request, @MappingTarget Student student);


    /**
     * Converts list of entities to list of response DTO
     */
    List<StudentResponse> toResponseList (List<Student> students);


    @Named("mapCourse")
    default Course mapCourse(Long courseId, @Context CourseRepository courseRepository){
        if(courseId==null){
            return null;
        }

        return courseRepository.findById(courseId)
                .orElseThrow(()-> new ApiException(
                        "Course not found with ID: "+courseId,
                        HttpStatus.NOT_FOUND
                ));

    }
}
