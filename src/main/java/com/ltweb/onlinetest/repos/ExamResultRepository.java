package com.ltweb.onlinetest.repos;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.ltweb.onlinetest.entities.ExamResult;
import java.util.List;

public interface ExamResultRepository extends JpaRepository<ExamResult,Long>{
    public Optional<ExamResult> findById(Long examResultId);
    public List<ExamResult> findByUserId(Long userId);
    public List<ExamResult> findByExamExamIdAndUserId(Long examId,Long userId);
    public List<ExamResult> findByExamExamId(Long examId);
    @Query(value = "SELECT * FROM exam_results WHERE exam_id = :examId ORDER BY score DESC LIMIT 10", nativeQuery = true)
    public List<ExamResult> findTop10ByExamId(Long examId);
    @Query("SELECT AVG(er.score) FROM ExamResult er WHERE er.exam.examId = :examId")
    Float findAverageScoreByExamId(Long examId);
    @Query("SELECT MAX(er.score) as highestScore FROM ExamResult er WHERE er.exam.examId = :examId")
    Float findHighestScoresByExamId( Long examId);
    @Query("SELECT MIN(er.score) as lowestScore  FROM ExamResult er WHERE er.exam.examId = :examId")
    Float findLowestScoresByExamId( Long examId);
}
