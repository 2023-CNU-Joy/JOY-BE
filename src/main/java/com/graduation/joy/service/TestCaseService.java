package com.graduation.joy.service;

import com.graduation.joy.domain.dto.TestCaseResponse;
import com.graduation.joy.domain.entity.Problem;
import com.graduation.joy.domain.entity.TestCase;
import com.graduation.joy.repository.TeseCaseRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class TestCaseService {
    private final TeseCaseRepository teseCaseRepository;

    public List<TestCaseResponse> getAllTestCase() {
        //존재하는 모든 문제 불러오기
        List<Problem> allProblem = teseCaseRepository.findDistinctProblemId();
        List<TestCaseResponse> testCaseResponses = new ArrayList<>();
        for (Problem problem : allProblem) {
            log.info("문제 id : " + problem.getId());
            //문제별 테스트 케이스
            List<TestCase> allByProblem = teseCaseRepository.findAllByProblem(problem);
            List<String> inputs = new ArrayList<>();
            List<String> outputs = new ArrayList<>();
            for(TestCase testCase : allByProblem){
                inputs.add(testCase.getInput());
                outputs.add(testCase.getOutput());
            }
            TestCaseResponse response = new TestCaseResponse(problem.getId(),inputs,outputs);
            testCaseResponses.add(response);
        }
        return testCaseResponses;


    }
}
