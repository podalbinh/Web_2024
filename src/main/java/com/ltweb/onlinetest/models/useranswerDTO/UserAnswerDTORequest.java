package com.ltweb.onlinetest.models.useranswerDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserAnswerDTORequest {
    private Long userAnswerId;
    private Long questionId;
    private Long choiceId;
    private boolean isCorrect;
}
