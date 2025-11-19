package com.nirdesh.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CourseMaterial {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer courseMaterialId;
    private String url;
    @OneToOne
    @JoinColumn(name = "course_id",
            referencedColumnName = "courseId",
            nullable = false)
    private Course course;
}
