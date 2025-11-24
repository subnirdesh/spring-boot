package com.nirdesh.coursemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.persistence.ManyToOne;

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
    @OneToOne(mappedBy = "course",
            cascade=CascadeType.ALL,
            fetch=FetchType.EAGER)
    private CourseMaterial courseMaterial;
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name = "teacher_id",referencedColumnName = "teacherId")
    private Teacher teacher;



}
