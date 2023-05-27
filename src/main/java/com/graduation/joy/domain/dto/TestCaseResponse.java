package com.graduation.joy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class TestCaseResponse {
    private Long problemId;
    private List<String> inputs;
    private List<String> outputs;
}
