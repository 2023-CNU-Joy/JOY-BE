package com.graduation.joy.repository;

import com.graduation.joy.domain.entity.Problem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProblemRepository extends JpaRepository<Problem,Long> {
}
