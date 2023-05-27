package com.graduation.joy.controller;

import com.graduation.joy.domain.dto.ResultRequest;
import com.graduation.joy.service.ResultService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/results")
@RequiredArgsConstructor
public class ResultController {
    private final ResultService resultService;

    @Operation(summary = "결과 생성", description = "각 학생들의 결과를 서버로 보낸다.")
    @PostMapping("")
    public ResponseEntity<String> createResult(@RequestBody ResultRequest resultRequest){
        resultService.create(resultRequest);
        return ResponseEntity.ok("결과가 성공적으로 전송되었습니다.");
    }
}
