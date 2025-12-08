package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.student.CreateStudentRequest;
import com.nirdesh.coursemanager.dto.student.StudentResponse;
import com.nirdesh.coursemanager.dto.student.UpdateStudentRequest;
import com.nirdesh.coursemanager.entity.Student;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.mapper.StudentMapper;
import com.nirdesh.coursemanager.repository.StudentRepository;
import com.nirdesh.coursemanager.service.StudentService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class StudentServiceImpl  implements StudentService {
    private final StudentRepository studentRepository;
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


        Student student=mapper.toEntity(request);
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
        return null;
    }

    @Override
    public List<StudentResponse> getAllStudents() {
        return List.of();
    }
}




