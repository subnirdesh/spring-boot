package com.nirdesh.coursemanager.entity;


import com.nirdesh.coursemanager.entity.base.BaseEntity;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Student extends BaseEntity {


    @Column(nullable = false)
    private String firstName;
    @Column(nullable = false)
    private String lastName;
    @Column(nullable = false,unique = true)
    private String rollNo;
    @Email
    @Column(nullable = false,unique = true)
    private String email;
    @Column(nullable = false)
    private String guardianName;
    @Column(nullable = false)
    private String guardianPhone;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "course_id",referencedColumnName = "id",nullable = false)
    private Course course;

}
