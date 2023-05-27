package com.graduation.joy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum ErrorCode {
    PROBLEM_NOT_FOUND(HttpStatus.NOT_FOUND, "해당 문제가 없습니다.");

    private final HttpStatus httpStatus;
    private final String message;
}
