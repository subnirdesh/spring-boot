package com.nirdesh.coursemanager.controller;

import com.nirdesh.coursemanager.dto.module.CreateModuleRequest;
import com.nirdesh.coursemanager.dto.module.ModuleResponse;
import com.nirdesh.coursemanager.dto.module.UpdateModuleRequest;
import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import com.nirdesh.coursemanager.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/module")
@RequiredArgsConstructor
public class ModuleController {
    private final ModuleService moduleService;

    @GetMapping
    public ResponseEntity<ApiResponse<List<ModuleResponse>>> getAllModules(){

        List<ModuleResponse> modules=moduleService.getAllModules();

        ApiResponse<List<ModuleResponse>> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Modules fetched successfully.",
                modules
        );

        return ResponseEntity.ok(response);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<ModuleResponse>> getModule(@PathVariable Long id){

        ModuleResponse module=moduleService.getModule(id);


        ApiResponse<ModuleResponse> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Module fetched successfully",
                module
        );

        return ResponseEntity.ok(response);
    }

    @PostMapping
    public ResponseEntity<ApiResponse<ModuleResponse>> createModule(@RequestBody CreateModuleRequest request){

        ModuleResponse module =moduleService.createModule(request);

        ApiResponse<ModuleResponse> response=ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Module created successfully",
                module
        );

        return ResponseEntity.ok(response);
    }

    @PatchMapping("/{moduleCode}")
    public ResponseEntity<ApiResponse<ModuleResponse>> updateModule(@PathVariable String moduleCode, @RequestBody UpdateModuleRequest request){

        ModuleResponse module=moduleService.updateModule(moduleCode,request);

        ApiResponse<ModuleResponse> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Module updated successfully",
                module
        );

        return ResponseEntity.ok(response);
    }
}
