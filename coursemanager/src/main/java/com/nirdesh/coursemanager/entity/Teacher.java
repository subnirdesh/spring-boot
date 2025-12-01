package com.nirdesh.coursemanager.entity;

import com.nirdesh.coursemanager.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Entity
@NoArgsConstructor
@Getter
@Setter
@AllArgsConstructor

public class Teacher extends BaseEntity {


    @Column(nullable = false)
    private  String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable=false, unique = true)
    private String email;
    @Column(nullable=false, unique = true)
    private String phone;
    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.MERGE})
    @JoinTable(
            name="teacher_module",
            joinColumns = @JoinColumn(name="teacher_id",referencedColumnName = "id"),
            inverseJoinColumns =@JoinColumn(name="module_id",referencedColumnName = "id")
    )
    private Set<Module> modules=new HashSet<>();


}
