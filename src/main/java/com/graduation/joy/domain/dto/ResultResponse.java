package com.graduation.joy.domain.dto;

import java.sql.Timestamp;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Getter
public class ResultResponse {
    private String studentId;
    private List<Long> correctProblemId;
    private List<Long> wrongProblemId;
    private float correctRate;
    private Timestamp endTime;
}
