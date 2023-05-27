package com.graduation.joy.domain.dto;

import com.graduation.joy.domain.entity.Problem;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProblemResponse {
    private Long id;
    private String title;
    private String content;
    private List<String> exampleTestInput;
    private List<String> exampleTestOut;

    public static ProblemResponse from(Problem problem) {
        List<String> exampleTestInput = new ArrayList<>();
        exampleTestInput.add(problem.getExampleTestInput());
        List<String> exampleTestOutput = new ArrayList<>();
        exampleTestOutput.add(problem.getExampleTestOut());
        return new ProblemResponse(problem.getId(), problem.getTitle(), problem.getContent(),
                exampleTestInput, exampleTestOutput);
    }
}
