package com.graduation.joy.service;

import com.graduation.joy.domain.dto.ProblemRequest;
import com.graduation.joy.domain.dto.ProblemResponse;
import com.graduation.joy.domain.entity.Problem;
import com.graduation.joy.repository.ProblemRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProblemService {
    private final ProblemRepository problemRepository;
    public List<ProblemResponse> getAllProblem() {
        List<Problem> allProblem = problemRepository.findAll();
        return allProblem.stream()
                .map(ProblemResponse::from)
                .collect(Collectors.toList());
    }

    public void makeProblem(ProblemRequest problemRequest) {
        Problem problem = Problem.builder()
                .title(problemRequest.getTitle())
                .content(problemRequest.getContent())
                .exampleTestInput(problemRequest.getExampleTestInput())
                .exampleTestOut(problemRequest.getExampleTestOutput())
                .build();
        problemRepository.save(problem);
    }
}
