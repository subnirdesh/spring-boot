package com.nirdesh.coursemanager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long courseId;
    @Column(nullable = false,unique = true)
    private String courseName;
    private String description;
    @Column(nullable = false)
    private Integer credit;
    @OneToMany(mappedBy ="course",cascade= CascadeType.ALL,orphanRemoval = true,fetch = FetchType.LAZY)
    private List<Module> modules=new ArrayList<>();
    @OneToMany(mappedBy = "course",cascade = CascadeType.ALL,fetch=FetchType.LAZY)
    private List<Student> students=new ArrayList<>();
    @ManyToMany(mappedBy = "courses", fetch = FetchType.LAZY)
    private Set<Teacher> teachers = new HashSet<>();







}
