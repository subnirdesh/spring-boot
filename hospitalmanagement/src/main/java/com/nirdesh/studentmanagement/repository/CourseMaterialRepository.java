package com.nirdesh.studentmanagement.repository;

import com.nirdesh.studentmanagement.entity.CourseMaterial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseMaterialRepository extends JpaRepository<CourseMaterial,Integer> {

}
