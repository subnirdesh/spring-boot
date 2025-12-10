package com.nirdesh.coursemanager.controller;



import com.nirdesh.coursemanager.dto.coursematerial.CourseMaterialResponse;
import com.nirdesh.coursemanager.dto.coursematerial.CreateCourseMaterialRequest;
import com.nirdesh.coursemanager.dto.coursematerial.UpdateCourseMaterialRequest;
import com.nirdesh.coursemanager.dto.reponse.ApiResponse;
import com.nirdesh.coursemanager.service.CourseMaterialService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api/course-material")
@RequiredArgsConstructor
@Validated
public class CourseMaterialController {
    private final CourseMaterialService courseMaterialService;


    @GetMapping
    public ResponseEntity<ApiResponse<List<CourseMaterialResponse>>> getAllCourseMaterials(){

        List<CourseMaterialResponse> courseMaterials =courseMaterialService.getAllCourseMaterial();

        ApiResponse<List<CourseMaterialResponse>> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Course Materials fetched successfully",
                courseMaterials
        );

        return  ResponseEntity.ok(response);

    }


    @GetMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseMaterialResponse>> getCourseMaterial(@PathVariable Long id){
        CourseMaterialResponse courseMaterial =courseMaterialService.getCourseMaterial(id);

        ApiResponse<CourseMaterialResponse> response=ApiResponse.success(
                HttpStatus.OK.value(),
                "Course Material Fetched Successfully",
                courseMaterial
        );

        return ResponseEntity.ok(response);

    }

    @PostMapping
    public ResponseEntity<ApiResponse<CourseMaterialResponse>> createCourseMaterial(@Valid @RequestBody CreateCourseMaterialRequest request){

        CourseMaterialResponse courseMaterial=courseMaterialService.createCourseMaterial(request);

        ApiResponse<CourseMaterialResponse> response= ApiResponse.success(
                HttpStatus.CREATED.value(),
                "Course Material created successfully",
                courseMaterial
        );

        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<ApiResponse<CourseMaterialResponse>> updateCourseMaterial(@PathVariable Long id, @Valid @RequestBody UpdateCourseMaterialRequest request){

         CourseMaterialResponse courseMaterial= courseMaterialService.updateCourseMaterial(id,request);

         ApiResponse<CourseMaterialResponse> response = ApiResponse.success(
                 HttpStatus.OK.value(),
                 "Course Material updated successfully",
                 courseMaterial

         );
         return ResponseEntity.ok(response);
    }

}
