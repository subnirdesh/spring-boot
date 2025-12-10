package com.nirdesh.coursemanager.controller;


import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import com.nirdesh.coursemanager.dto.teacher.CreateTeacherRequest;
import com.nirdesh.coursemanager.dto.teacher.TeacherResponse;
import com.nirdesh.coursemanager.dto.teacher.UpdateTeacherRequest;
import com.nirdesh.coursemanager.service.TeacherService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/teacher")
@RequiredArgsConstructor
@Validated
public class TeacherController {
    private final TeacherService teacherService;



    @GetMapping
    public ResponseEntity<ApiResponse<List<TeacherResponse>>> getAllTeachers(){

        List<TeacherResponse> teachers=teacherService.getAllTeachers();

        ApiResponse<List<TeacherResponse>> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Teachers found successfully",
                teachers
        );

        return ResponseEntity.ok(response);

    }


    @GetMapping("/{id}")
    public  ResponseEntity<ApiResponse<TeacherResponse>> getTeacher(@PathVariable Long id){
         TeacherResponse teacher =teacherService.getTeacher(id);

         ApiResponse<TeacherResponse> response= ApiResponse.success(
                 HttpStatus.OK.value(),
                 "Teacher found successfully ",
                 teacher
         );

         return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<TeacherResponse>> createTeacher(@Valid  @RequestBody CreateTeacherRequest request){

        TeacherResponse teacher=teacherService.createTeacher(request);

        ApiResponse<TeacherResponse> response=ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Teacher created successfully",
                teacher
        );

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<TeacherResponse>> updateTeacher(@PathVariable Long id, @Valid @RequestBody UpdateTeacherRequest request){

        TeacherResponse teacher=teacherService.updateTeacher(id, request);

        ApiResponse<TeacherResponse> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Teacher updated successfully",
                teacher
        );

        return ResponseEntity.ok(response);
    }

}
