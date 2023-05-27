package com.graduation.joy.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class ProblemException extends RuntimeException{
    private ErrorCode errorCode;
    private String message;

}
