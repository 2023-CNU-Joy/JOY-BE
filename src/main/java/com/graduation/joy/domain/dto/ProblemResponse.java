package com.graduation.joy.domain.dto;

import com.graduation.joy.domain.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemResponse {
    private Long id;
    private String title;
    private String content;
    private String exampleTestInput;
    private String exampleTestOut;

    public static ProblemResponse from(Problem problem) {
        return new ProblemResponse(problem.getId(), problem.getTitle(), problem.getContent(),
                problem.getExampleTestInput(), problem.getExampleTestOut());
    }
}
