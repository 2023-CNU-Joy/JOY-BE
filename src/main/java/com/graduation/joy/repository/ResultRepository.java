package com.graduation.joy.repository;

import com.graduation.joy.domain.entity.Result;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ResultRepository extends JpaRepository<Result,String> {

    @Query(value = "select distinct(r.studentId) from Result r")
    List<String> findDistinctByStudentId();

    @Query("SELECT new com.graduation.joy.domain.entity.Result(id, studentId, result, problem, endTime) FROM Result WHERE endTime = (select max(endTime) from Result where studentId= ?1)")
    List<Result> findAllByStudentIdAndEndTime(String studentId);
}
