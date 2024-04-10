package com.ltweb.onlinetest.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltweb.onlinetest.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    public Optional<Exam> findById(Long examId);
}