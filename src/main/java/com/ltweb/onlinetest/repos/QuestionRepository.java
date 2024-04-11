package com.ltweb.onlinetest.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltweb.onlinetest.entities.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {
    public List<Question> findByExamExamId(Long examId);
    public Optional<Question> findById(Long questionId);
} 
