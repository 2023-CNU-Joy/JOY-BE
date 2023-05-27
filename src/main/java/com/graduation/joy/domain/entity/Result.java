package com.graduation.joy.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private boolean result;
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

}
