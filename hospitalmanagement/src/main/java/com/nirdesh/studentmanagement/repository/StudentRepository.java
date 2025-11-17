package com.nirdesh.studentmanagement.repository;

import com.nirdesh.studentmanagement.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    public List<Student> findByFirstName(String firstName);

}
