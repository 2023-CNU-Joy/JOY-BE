package com.graduation.joy.domain.entity;

import jakarta.persistence.*;
import java.sql.Timestamp;
import lombok.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class Result {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String studentId;
    private boolean result;
    @ManyToOne
    @JoinColumn(name = "problem_id")
    private Problem problem;
    private Timestamp endTime;

}
