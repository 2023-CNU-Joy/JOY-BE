package com.graduation.joy.controller;

import com.graduation.joy.domain.dto.TestCaseResponse;
import com.graduation.joy.service.TestCaseService;
import com.graduation.joy.utils.AESEncoder;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
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

    @Value("${secretKey}")
    private String secretKey;

    @GetMapping("")
    public ResponseEntity<String> getAllTestCase() throws Exception {
        List<TestCaseResponse> testCaseResponses= testCaseService.getAllTestCase();
        String encrypted = AESEncoder.encryptTestCaseList(secretKey, testCaseResponses);
        return ResponseEntity.ok(encrypted);
    }

}
