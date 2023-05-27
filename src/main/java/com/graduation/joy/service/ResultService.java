package com.graduation.joy.service;

import com.graduation.joy.domain.dto.ResultRequest;
import com.graduation.joy.domain.entity.Problem;
import com.graduation.joy.domain.entity.Result;
import com.graduation.joy.exception.ErrorCode;
import com.graduation.joy.exception.ProblemException;
import com.graduation.joy.repository.ProblemRepository;
import com.graduation.joy.repository.ResultRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ResultService {
    private final ResultRepository resultRepository;
    private final ProblemRepository problemRepository;

    public void create(ResultRequest resultRequest) {
        List<Boolean> results = resultRequest.getResults();
        String studentId = resultRequest.getStudentId();
        for (long i = 0; i < results.size(); i++) {
            Problem problem = problemRepository.findById(i + 1).orElseThrow(() -> new ProblemException(ErrorCode.PROBLEM_NOT_FOUND, ErrorCode.PROBLEM_NOT_FOUND.getMessage()));
            Result result = Result.builder()
                    .studentId(studentId)
                    .result(results.get((int)i))
                    .problem(problem)
                    .build();
            resultRepository.save(result);
        }
    }
}
