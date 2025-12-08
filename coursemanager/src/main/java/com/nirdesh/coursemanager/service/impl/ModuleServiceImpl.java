package com.nirdesh.coursemanager.service.impl;

import com.nirdesh.coursemanager.dto.module.CreateModuleRequest;
import com.nirdesh.coursemanager.dto.module.ModuleResponse;
import com.nirdesh.coursemanager.dto.module.UpdateModuleRequest;
import com.nirdesh.coursemanager.entity.Module;
import com.nirdesh.coursemanager.exception.ApiException;
import com.nirdesh.coursemanager.mapper.ModuleMapper;
import com.nirdesh.coursemanager.repository.CourseRepository;
import com.nirdesh.coursemanager.repository.ModuleRepository;
import com.nirdesh.coursemanager.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ModuleServiceImpl implements ModuleService {
    private final ModuleRepository moduleRepository;
    private final CourseRepository courseRepository;
    private final ModuleMapper mapper;
    private final ModuleService moduleService;


    @Override
    public ModuleResponse createModule(CreateModuleRequest request) {

        if(moduleRepository.existsByModuleCode(request.moduleCode())) {
            throw new ApiException(
                    "Module already exists",
                    HttpStatus.CONFLICT
            );

        }

        if(!courseRepository.existsById(request.courseId())){
            throw new ApiException(
                    "Course not found with ID: "+request.courseId(),
                    HttpStatus.NOT_FOUND
            );
        }

        Module module = mapper.toEntity(request);
        moduleRepository.save(module);


        return mapper.toResponse(module);
        }


    @Override
    public ModuleResponse updateModule(String moduleCode, UpdateModuleRequest request) {

        Module existingModule=moduleRepository.findByModuleCode(moduleCode)
                .orElseThrow(()-> new ApiException(
                " Module not with Code: "+request.moduleCode(),
                HttpStatus.NOT_FOUND
        )) ;

        mapper.updateEntity(request,existingModule);

        return mapper.toResponse(moduleRepository.save(existingModule));

    }


    @Override
    public ModuleResponse getModule(Long id) {
        Module module =moduleRepository.findById(id)
                .orElseThrow(()-> new ApiException(
                        " Module not with Code: "+ id,
                        HttpStatus.NOT_FOUND
                ));

        return mapper.toResponse(module);
    }

    @Override
    public List<ModuleResponse> getAllModules() {
       return mapper.toResponseList(moduleRepository.findAll());
    }
}
