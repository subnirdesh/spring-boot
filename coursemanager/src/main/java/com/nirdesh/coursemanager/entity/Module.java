package com.nirdesh.coursemanager.entity;

import com.nirdesh.coursemanager.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Module extends BaseEntity {

    @Column(nullable = false,unique = true)
    private String moduleName;
    @Column(nullable = false,unique = true)
    private String moduleCode;
    private String description;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false)
    private Course course;

}
