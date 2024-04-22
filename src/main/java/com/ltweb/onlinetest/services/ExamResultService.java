package com.ltweb.onlinetest.services;

import java.util.List;

import com.ltweb.onlinetest.entities.ExamResult;
import com.ltweb.onlinetest.models.StateScoreDTO;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTO;

public interface ExamResultService {
    public ExamResult findById(Long id);  
    public Long create (ExamResultDTO examResultDTO);
    public void delete(Long id);
    public List<ExamResult> findAll();
    public List<ExamResult> findByUserId(Long id);
    public List<ExamResult> findByExamId(Long id);
    public List<ExamResult> findByExamIdAndUserId(Long examId,Long id);
    public List<ExamResult> Top10ExamResult(Long examId);
    public StateScoreDTO state(Long examId);
} 