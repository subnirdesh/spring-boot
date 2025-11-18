package com.nirdesh.studentmanagement.repository;

import com.nirdesh.studentmanagement.entity.Student;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;



@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

    List<Student> findByFirstName(String firstName);
    List<Student> findByFirstNameContaining(String firstName);


    @Query("select s from Student s where s.email_address=:email")
     Student getStudentByEmailAddress(@Param("email") String emailAddress);

   @Modifying
    @Query(" update Student s  set s.firstName=:firstName where s.studentId=:id")
    int updateFirstNameByID(@Param("id") int id, @Param("firstName") String firstName );


}
