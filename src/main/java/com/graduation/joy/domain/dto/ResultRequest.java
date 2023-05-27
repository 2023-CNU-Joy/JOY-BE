package com.graduation.joy.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ResultRequest {
    private String studentId;
    private List<Boolean> results;
}
