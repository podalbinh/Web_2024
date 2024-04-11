package com.ltweb.onlinetest.models.ChoiceDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ChoiceDTO {
    private Long choiceId;
    private String choiceText;
    private boolean isCorrect;
    private Long questionId;
    public ChoiceDTO(Long choiceId, String choiceText, boolean isCorrect, Long questionId) {
        this.choiceId = choiceId;
        this.choiceText = choiceText;
        this.isCorrect = isCorrect;
        this.questionId = questionId;
    }
}
