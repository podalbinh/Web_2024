package com.ltweb.onlinetest.models.questionDTO;

import java.util.List;

import com.ltweb.onlinetest.models.choiceDTO.ChoiceDTO;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class QuestionDTOResponse {
    private Long questionId;
    private String examName;
    private String questionText;
    private List<ChoiceDTO> listChoice;
    
    public QuestionDTOResponse(Long questionId, String examName, String questionText) {
        this.questionId = questionId;
        this.examName = examName;
        this.questionText = questionText;
    }

    public List<ChoiceDTO> getListChoice() {
        return listChoice;
    }

    public void setListChoiceDTO(List<ChoiceDTO> listChoice) {
        this.listChoice = listChoice;
    }
}
