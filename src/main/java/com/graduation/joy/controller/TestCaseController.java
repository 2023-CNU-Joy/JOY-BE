package com.graduation.joy.controller;

import com.graduation.joy.domain.dto.TestCaseResponse;
import com.graduation.joy.service.TestCaseService;
import com.graduation.joy.utils.AESEncoder;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation(summary = "테스트케이스 조회", description = "출제한 모든 문제의 테스트케이스 조회, AES256으로 암호화하여 전송")
    @GetMapping("")
    public ResponseEntity<List<List<List<String>>> > getAllTestCase() throws Exception {
        List<TestCaseResponse> testCaseResponses= testCaseService.getAllTestCase();
        List<List<List<String>>>  encrypted = AESEncoder.encryptTestCaseList(secretKey, testCaseResponses);
        return ResponseEntity.ok(encrypted);
    }

}
