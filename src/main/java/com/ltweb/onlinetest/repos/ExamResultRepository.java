package com.ltweb.onlinetest.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltweb.onlinetest.entities.ExamResult;
import java.util.List;

public interface ExamResultRepository extends JpaRepository<ExamResult,Long>{
    public Optional<ExamResult> findById(Long examResultId);
    public List<ExamResult> findByUserId(Long userId);
    public List<ExamResult> findByExamExamId(Long examId);
}
