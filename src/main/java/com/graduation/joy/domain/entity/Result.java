package com.graduation.joy.domain.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;

@Entity
@Getter
public class Result {
    @Id
    private String studentId;
    private boolean result;
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;

}
