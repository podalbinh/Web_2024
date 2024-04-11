package com.ltweb.onlinetest.repos;

import com.ltweb.onlinetest.entities.Exam;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Long> {
    public Optional<Exam> findById(Long examId);
}

