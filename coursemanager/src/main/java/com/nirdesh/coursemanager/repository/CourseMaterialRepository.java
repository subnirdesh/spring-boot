package com.nirdesh.coursemanager.repository;

import com.nirdesh.coursemanager.entity.CourseMaterial;
import jakarta.validation.constraints.NotBlank;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Long> {

    boolean existsByUrl(String url);
}
