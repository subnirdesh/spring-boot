package com.nirdesh.coursemanager.repository;

import com.nirdesh.coursemanager.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

    boolean existsByRollNo(String rollNo);
    Optional<Student> findByRollNo(String rollNo);




}
