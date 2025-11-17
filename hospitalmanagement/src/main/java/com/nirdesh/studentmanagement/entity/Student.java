package com.nirdesh.studentmanagement.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Student {

    @Id
    @SequenceGenerator(name = "student_sequence",
                        sequenceName = "student_sequence",
                        allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private int studentId;
    private String firstName;
    private String lastName;
    @Column(nullable = false, unique = true)
    private String email_address;
    private String guardianName;
    @Column(nullable = false,unique = true)
    private String guardianPhone;



}
