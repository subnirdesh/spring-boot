package com.nirdesh.coursemanager.service;

import com.nirdesh.coursemanager.dto.module.CreateModuleRequest;
import com.nirdesh.coursemanager.dto.module.ModuleResponse;
import com.nirdesh.coursemanager.dto.module.UpdateModuleRequest;

import java.util.List;

public interface ModuleService {
    ModuleResponse  createModule(CreateModuleRequest request);
    ModuleResponse   updateModule(String moduleCode, UpdateModuleRequest request);
    ModuleResponse    getModule(Long id);
    List<ModuleResponse> getAllModules();
}
