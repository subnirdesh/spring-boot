package com.nirdesh.coursemanager.entity;

import com.nirdesh.coursemanager.entity.base.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@NoArgsConstructor


public class CourseMaterial extends BaseEntity {

    @Column(nullable = false)
    private String url;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="course_id", referencedColumnName = "id",nullable = false)
    private Course course;





}
