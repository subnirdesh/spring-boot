package com.nirdesh.coursemanager.controller;

import com.nirdesh.coursemanager.dto.module.ModuleResponse;
import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import com.nirdesh.coursemanager.service.ModuleService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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

        )



    }
}
