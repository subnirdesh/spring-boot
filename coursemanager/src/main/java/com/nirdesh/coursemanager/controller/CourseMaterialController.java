package com.nirdesh.coursemanager.controller;

import com.nirdesh.coursemanager.entity.CourseMaterial;
import com.nirdesh.coursemanager.service.CourseMaterialService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/course-material")
public class CourseMaterialController {
    private final CourseMaterialService courseMaterialService;


    public CourseMaterialController(CourseMaterialService courseMaterialService) {
        this.courseMaterialService = courseMaterialService;
    }

    @GetMapping
    public List<CourseMaterial>  getAllCourseMaterial(){
        return courseMaterialService.getAllCourseMaterial();
    }

    @PostMapping("/course-id/{courseId}")
    public CourseMaterial createCourseMaterial(@PathVariable Integer courseId, @RequestBody Map<String,String> urlMap){
        String url=urlMap.get("url");
        return courseMaterialService.createCourseMaterial(courseId,url);
    }
}
