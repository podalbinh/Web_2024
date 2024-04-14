package com.ltweb.onlinetest.models.questionDTO;

import lombok.Data;

@Data
public class QuestionDTOAll {
    private Long questionId;
    private String examName;
    private String questionText;
    public QuestionDTOAll(Long questionId, String examName, String questionText) {
        this.questionId = questionId;
        this.examName = examName;
        this.questionText = questionText;
    }
}
