package com.nirdesh.coursemanager.entity;

import com.nirdesh.coursemanager.entity.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import lombok.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Course extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String courseCode;
    @Column(nullable = false,unique = true)
    private String courseName;
    private String description;
    @Column(nullable = false)
    private Integer credit;
    @OneToMany(mappedBy ="course",cascade= CascadeType.ALL,fetch = FetchType.LAZY)
    private List<Module> modules;
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Student> students;








}
