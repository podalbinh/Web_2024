package com.ltweb.onlinetest.models.QuestionDTO;

import java.util.List;

import com.ltweb.onlinetest.models.ChoiceDTO.ChoiceDTO;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class QuestionDTO {
    private Long questionId;
    private Long examId;
    private String questionText;
    private List<ChoiceDTO> listChoice;
}
