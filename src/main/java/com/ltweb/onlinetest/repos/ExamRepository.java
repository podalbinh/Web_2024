package com.ltweb.onlinetest.repos;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltweb.onlinetest.entities.Exam;

public interface ExamRepository extends JpaRepository<Exam,Long> {
    public Optional<Exam> findById(Long examId);
    @Query("SELECT e FROM Exam e WHERE " +
    "e.examName LIKE CONCAT('%',:query, '%')")
    public List<Exam> searchExam(String query);
}