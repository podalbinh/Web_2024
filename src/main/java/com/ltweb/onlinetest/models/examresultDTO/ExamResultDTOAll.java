package com.ltweb.onlinetest.models.examresultDTO;

import java.time.LocalDateTime;

import lombok.Data;
@Data
public class ExamResultDTOAll {
    private Long ExamResultId;
    private String userName;
    private String examName;
    private String examType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Float score;
    public ExamResultDTOAll(Long examResultId, String userName, String examName, String examType,
            LocalDateTime startTime, LocalDateTime endTime, Float score) {
        ExamResultId = examResultId;
        this.userName = userName;
        this.examName = examName;
        this.examType = examType;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
    }

}