package com.graduation.joy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class ProblemRequest {
    private String title;
    private String content;
    private String exampleTestInput;
    private String exampleTestOutput;
}
