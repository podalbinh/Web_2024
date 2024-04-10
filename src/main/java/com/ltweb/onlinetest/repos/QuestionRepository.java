package com.ltweb.onlinetest.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltweb.onlinetest.entities.Choice;
import com.ltweb.onlinetest.entities.Question;

public interface QuestionRepository extends JpaRepository<Question,Long> {
    public Optional<Question> findById(Long questionId);
}
