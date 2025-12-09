package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.teacher.CreateTeacherRequest;
import com.nirdesh.coursemanager.dto.teacher.TeacherResponse;
import com.nirdesh.coursemanager.dto.teacher.UpdateTeacherRequest;
import com.nirdesh.coursemanager.entity.Teacher;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.mapper.TeacherMapper;
import com.nirdesh.coursemanager.repository.ModuleRepository;
import com.nirdesh.coursemanager.repository.TeacherRepository;
import com.nirdesh.coursemanager.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherClassImpl implements TeacherService{
    private final TeacherRepository teacherRepository;
    private final TeacherMapper mapper;
    private final ModuleRepository moduleRepository;



    @Override
    public TeacherResponse createTeacher(CreateTeacherRequest request) {

        if(teacherRepository.existsByEmail(request.email())){
            throw new ApiException(
                    "Teacher already exists with email: "+request.email(),
                    HttpStatus.CONFLICT
            );
        }

        for(Long moduleId: request.moduleId()){
            if(!moduleRepository.existsById(moduleId)){
                throw new ApiException(
                        "Module not found with ID: "+moduleId,
                        HttpStatus.NOT_FOUND
                );
            }
        }

        Teacher teacher =mapper.toEntity(request);
        teacherRepository.save(teacher);

        return mapper.toResponse(teacher);


    }

    @Override
    public TeacherResponse updateTeacher(Long id, UpdateTeacherRequest request) {

        Teacher existingTeacher=teacherRepository.findById(id)
                .orElseThrow(()->  new ApiException(
                        "Teacher not found with ID: "+id,
                        HttpStatus.NOT_FOUND
                ));

        mapper.updateEntity(request,existingTeacher);

        return mapper.toResponse(teacherRepository.save(existingTeacher));
    }

    @Override
    public TeacherResponse getTeacher(Long id) {
        Teacher teacher=teacherRepository.findById(id)
                .orElseThrow(()-> new ApiException(
                        "Teacher not found with ID: "+id,
                        HttpStatus.NOT_FOUND
                ));

        return mapper.toResponse(teacher);
    }

    @Override
    public List<TeacherResponse> getAllTeachers() {
        return mapper.toReponseList(teacherRepository.findAll());
    }
}
