package com.ltweb.onlinetest.models.useranswerDTO;

import lombok.Data;

@Data
public class UserAnswerDTO {
    private Long userAnswerId;
    private String question;
    private String choice;
    private boolean isCorrect;
    public UserAnswerDTO(Long userAnswerId, String question, String choice, boolean isCorrect) {
        this.userAnswerId = userAnswerId;
        this.question = question;
        this.choice = choice;
        this.isCorrect = isCorrect;
    }
}
