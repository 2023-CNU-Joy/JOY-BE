package com.graduation.joy.service;

import com.graduation.joy.domain.dto.ResultRequest;
import com.graduation.joy.domain.dto.ResultResponse;
import com.graduation.joy.domain.entity.Problem;
import com.graduation.joy.domain.entity.Result;
import com.graduation.joy.exception.ErrorCode;
import com.graduation.joy.exception.ProblemException;
import com.graduation.joy.repository.ProblemRepository;
import com.graduation.joy.repository.ResultRepository;
import java.sql.Timestamp;
import java.util.ArrayList;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class ResultService {
    private final ResultRepository resultRepository;
    private final ProblemRepository problemRepository;

    public void create(ResultRequest resultRequest) {
        List<Boolean> results = resultRequest.getResults();
        String studentId = resultRequest.getStudentId();
        Timestamp endTime = new Timestamp(System.currentTimeMillis());
        for (long i = 0; i < results.size(); i++) {
            Problem problem = problemRepository.findById(i + 1).orElseThrow(() -> new ProblemException(ErrorCode.PROBLEM_NOT_FOUND, ErrorCode.PROBLEM_NOT_FOUND.getMessage()));
            Result result = Result.builder()
                    .studentId(studentId)
                    .result(results.get((int)i))
                    .problem(problem)
                    .endTime(endTime)
                    .build();
            resultRepository.save(result);
        }
    }

    public List<ResultResponse> getAllResult() {
        List<ResultResponse> resultResponses = new ArrayList<>();
        List<String> allStudentId = resultRepository.findDistinctByStudentId();
        log.info("총 학생 수 : " + allStudentId.size());
        for(String studentId : allStudentId){
            //가장 최근에 제출한 결과만 조회
            List<Result> allResultsByStudent = resultRepository.findAllByStudentIdAndEndTime(studentId);
            Timestamp endTime = allResultsByStudent.get(0).getEndTime();
            List<Long> correctProblemId = new ArrayList<>();
            List<Long> wrongProblemId = new ArrayList<>();
            for(Result result : allResultsByStudent){
                if(result.isResult()) correctProblemId.add(result.getProblem().getId());
                if(!result.isResult()) wrongProblemId.add(result.getProblem().getId());
            }
            float correctRate = (float)correctProblemId.size() / (float) (correctProblemId.size() + wrongProblemId.size());
            log.info("정답률 : " + correctRate);
            resultResponses.add(new ResultResponse(studentId, correctProblemId, wrongProblemId,correctRate,endTime));
        }
        return resultResponses;
    }

//    private boolean isLastAnswer(List<Result> allResultByStudent, Result result){
//        resultRepository.findByStudendIDAndProblemId()
//    }
}
