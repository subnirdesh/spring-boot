package com.nirdesh.coursemanager.dto.course;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



public record CourseResponse(
     Long id,
     String courseName,
     Integer credit
){}
