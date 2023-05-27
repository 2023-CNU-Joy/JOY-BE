package com.graduation.joy.domain.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Entity
@Getter
public class TestCase {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String input;
    private String output;
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
}
