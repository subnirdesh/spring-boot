package com.nirdesh.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor

public class Course {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseId;
    private String courseName;
    private Integer credit;
    @OneToOne(mappedBy = "course",cascade=CascadeType.ALL)
    private CourseMaterial courseMaterial;



}
