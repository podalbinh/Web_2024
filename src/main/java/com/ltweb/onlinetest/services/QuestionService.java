package com.ltweb.onlinetest.services;

import java.util.List;

import com.ltweb.onlinetest.entities.Question;
import com.ltweb.onlinetest.models.questionDTO.QuestionDTO;

public interface QuestionService {
    public Question getQuestionById(Long questionId);
    public Long createQuestion(QuestionDTO questionDTO);
    public void updateQuestion(Long id, QuestionDTO questionDTO);
    public void deleteQuestionById(Long questionId);
    public List<Question> findAllQuestions();
    public List<Question> findQuestionsByExamId(Long id);
}
