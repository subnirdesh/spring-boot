package com.nirdesh.coursemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Module {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long moduleId;
    @Column(nullable = false,unique = true)
    private String moduleName;
    @Column(nullable = false,unique = true)
    private String moduleCode;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "courseId",nullable = false)
    private Course course;

}
