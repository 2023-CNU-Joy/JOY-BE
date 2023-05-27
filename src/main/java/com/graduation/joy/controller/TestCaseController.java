package com.graduation.joy.controller;

import com.graduation.joy.domain.dto.TestCaseResponse;
import com.graduation.joy.service.TestCaseService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/testcases")
@RequiredArgsConstructor
public class TestCaseController {
    private final TestCaseService testCaseService;

    @GetMapping("")
    public ResponseEntity<List<TestCaseResponse>> getAllTestCase(){
        List<TestCaseResponse> testCaseResponses= testCaseService.getAllTestCase();
        return ResponseEntity.ok(testCaseResponses);
    }

}
