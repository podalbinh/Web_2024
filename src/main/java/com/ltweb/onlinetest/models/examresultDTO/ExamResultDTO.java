package com.ltweb.onlinetest.models.examresultDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTO;
import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTORequest;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
@Data
@Getter
@Setter
public class ExamResultDTO {
    private Long ExamResultId;
    private Long userId;
    private Long examId;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Float score;
    private Boolean status;
    private List<UserAnswerDTORequest> listUserAnswerDTO;

}
