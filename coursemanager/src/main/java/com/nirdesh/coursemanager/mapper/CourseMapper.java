package com.nirdesh.coursemanager.mapper;

import com.nirdesh.coursemanager.dto.course.CourseResponse;
import com.nirdesh.coursemanager.dto.course.CreateCourseRequest;
import com.nirdesh.coursemanager.entity.Course;
import org.apache.catalina.User;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {

    public CourseResponse toResponse(Course course){
        if(course==null) return null;


        return CourseResponse.builder()
                .courseId(course.getCourseId())
                .courseName((course.getCourseName()))
                .credit(course.getCredit()).
                build();

    }

    public Course toEntity(CreateCourseRequest request){
        if(request==null) return null;

       return Course.builder()
               .courseName(request.courseName())
               .description(request.description())
               .credit((request.credit()))
               .build();

    }




}
