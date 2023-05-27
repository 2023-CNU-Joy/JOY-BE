package com.graduation.joy.controller;

import com.graduation.joy.domain.dto.ProblemResponse;
import com.graduation.joy.service.ProblemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/problems")
@RequiredArgsConstructor
public class ProblemController {
    private final ProblemService problemService;

    @Operation(summary = "문제 조회", description = "출제한 모든 문제 조회")
    @GetMapping("")
    public ResponseEntity<List<ProblemResponse>> getAllProblems(){
        List<ProblemResponse> allProblem = problemService.getAllProblem();
        return ResponseEntity.ok().body(allProblem);
    }
}
