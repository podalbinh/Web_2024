package com.ltweb.onlinetest.models.examresultDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTORequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class ExamResultDTO {
    private Long examId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Boolean status;
    private List<UserAnswerDTORequest> listUserAnswerDTO;

}
