package com.ltweb.onlinetest.services;

import java.util.List;

import com.ltweb.onlinetest.entities.ExamResult;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTO;

public interface ExamResultService {
    public ExamResult findById(Long id);  
    public Long create (ExamResultDTO examResultDTO);
    public void delete(Long id);
    public List<ExamResult> findAll();
    public List<ExamResult> findByUserId(Long id);
    public List<ExamResult> findByExamId(Long id);
} 