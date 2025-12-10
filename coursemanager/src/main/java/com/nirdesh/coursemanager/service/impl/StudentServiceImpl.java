package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.student.CreateStudentRequest;
import com.nirdesh.coursemanager.dto.student.FilterStudentDTO;
import com.nirdesh.coursemanager.dto.student.StudentResponse;
import com.nirdesh.coursemanager.dto.student.UpdateStudentRequest;
import com.nirdesh.coursemanager.entity.Student;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.mapper.StudentMapper;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.repository.StudentRepository;
import com.nirdesh.coursemanager.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {
    private final StudentRepository studentRepository;
    private final CourseRepository courseRepository;
    private final StudentMapper mapper;




    @Override
    @Transactional
    public StudentResponse createStudent(CreateStudentRequest request) {

        if(studentRepository.existsByRollNo(request.rollNo())){
            throw new ApiException(
                    "Student with Roll No already exists: "+request.rollNo(),
                    HttpStatus.CONFLICT
            );
        }

        if(!courseRepository.existsById(request.courseId())){
            throw new ApiException(
                    " Course not found with ID: "+request.courseId(),
                    HttpStatus.NOT_FOUND
            );
        }


        Student student=mapper.toEntity(request,courseRepository );
        studentRepository.save(student);

        return mapper.toResponse(student);

    }

    @Override
    @Transactional
    public StudentResponse updateStudent(String rollNo, UpdateStudentRequest request) {

        Student existingStudent=studentRepository.findByRollNo(rollNo)
                .orElseThrow(()-> new ApiException(
                        "Student Not found with Roll No: "+request.rollNo(),
                        HttpStatus.NOT_FOUND
                ));

        mapper.updateEntity(request,existingStudent);

        return mapper.toResponse(studentRepository.save(existingStudent));


    }

    @Override
    public StudentResponse getStudent(Long id) {
        Student student=studentRepository.findById(id)
                .orElseThrow(()-> new ApiException(
                        "Student not found with ID: "+id,
                        HttpStatus.NOT_FOUND
                ));

        return mapper.toResponse(student);
    }


    @Override
    public List<StudentResponse> getAllStudents() {
        return mapper.toResponseList(studentRepository.findAll());
    }

    @Override
    public Map<String, String> filterStudent(FilterStudentDTO students) {

        List<Student> studentList= Arrays.stream(students.students())
                .map(studentRepository::findByFirstName)
                .flatMap(Optional::stream)
                .toList();

        Map<String,String>  studentCourseMap=studentList.stream()
                .collect(Collectors.toMap(
                        Student::getFirstName,
                        student -> student.getCourse().getCourseName(),
                        (existing,replacement)-> existing
                ));

        return studentCourseMap;
    }
}




