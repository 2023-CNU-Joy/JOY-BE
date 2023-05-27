package com.graduation.joy.repository;

import com.graduation.joy.domain.entity.Problem;
import com.graduation.joy.domain.entity.TestCase;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TeseCaseRepository extends JpaRepository<TestCase,Long> {
    @Query("SELECT DISTINCT problem From TestCase")
    List<Problem> findDistinctProblemId();

    List<TestCase> findAllByProblem(Problem problem);
}
