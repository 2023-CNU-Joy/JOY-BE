package com.graduation.joy.controller;

import com.graduation.joy.domain.dto.ProblemRequest;
import com.graduation.joy.domain.dto.ProblemResponse;
import com.graduation.joy.service.ProblemService;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

    @Operation(summary = "문제 생성", description = "문제 출제")
    @PostMapping("")
    public ResponseEntity<String> makeProblem(@RequestBody ProblemRequest problemRequest){
        problemService.makeProblem(problemRequest);
        return ResponseEntity.ok().body("문제가 정상적으로 생성되었습니다.");
    }
}
