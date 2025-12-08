package com.nirdesh.coursemanager.controller;

import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import com.nirdesh.coursemanager.dto.student.CreateStudentRequest;
import com.nirdesh.coursemanager.dto.student.StudentResponse;
import com.nirdesh.coursemanager.dto.student.UpdateStudentRequest;
import com.nirdesh.coursemanager.entity.Student;
import com.nirdesh.coursemanager.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/api/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<StudentResponse>>> getAllStudents(){
        List<StudentResponse> students= studentService.getAllStudents();

        ApiResponse<List<StudentResponse>> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Students fetched successfully.",
                students
        );

        return ResponseEntity.ok(response);
    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<StudentResponse>> getStudent(@PathVariable Long id){
        StudentResponse student=studentService.getStudent(id);

        ApiResponse<StudentResponse> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Student fetched successfully",
                student
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<StudentResponse>> createStudent(@RequestBody CreateStudentRequest request){
        StudentResponse student=studentService.createStudent(request);

        ApiResponse<StudentResponse> response=ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Student created successfully",
                student
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }


    @PatchMapping("/{rollNo}")
    public ResponseEntity<ApiResponse<StudentResponse>> updateStudent(@PathVariable String rollNo, @RequestBody UpdateStudentRequest request){

        StudentResponse student=studentService.updateStudent(rollNo,request);

        ApiResponse<StudentResponse> response =ApiResponse.success(
                HttpStatus.OK.value(),
                "Student Updated Successfully",
                student
        );

        return ResponseEntity.ok(response);
    }




}
