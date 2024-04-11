package com.ltweb.onlinetest.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.models.ExamDTO;

@Service
public interface ExamService {
    public Long createExam(ExamDTO examDTO);
    public Exam getExamById(Long examId);
    public void saveOrUpdateExam(ExamDTO examDTO);
    public void deleteExam(Long examId);
    public List<Exam> findAll();
}

