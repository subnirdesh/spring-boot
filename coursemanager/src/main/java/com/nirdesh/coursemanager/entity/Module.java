package com.nirdesh.coursemanager.entity;

import com.nirdesh.coursemanager.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Module extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String moduleName;
    @Column(nullable = false,unique = true)
    private String moduleCode;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false)
    private Course course;
    @ManyToMany(mappedBy = "modules", fetch = FetchType.LAZY)
    private Set<Teacher> teachers ;

}
