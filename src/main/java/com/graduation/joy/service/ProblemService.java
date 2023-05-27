package com.graduation.joy.service;

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
}
