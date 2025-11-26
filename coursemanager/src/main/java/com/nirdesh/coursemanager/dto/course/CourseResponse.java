package com.nirdesh.coursemanager.dto.course;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Builder
public record CourseResponse(
     Long courseId,
     String courseName,
     Integer credit
){}
