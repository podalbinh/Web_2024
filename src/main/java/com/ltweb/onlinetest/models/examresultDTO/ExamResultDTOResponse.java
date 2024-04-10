package com.ltweb.onlinetest.models.examresultDTO;

import java.time.LocalDateTime;
import java.util.List;

import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTO;

import lombok.Data;
import lombok.NoArgsConstructor;
@NoArgsConstructor
@Data
public class ExamResultDTOResponse {
    private Long ExamResultId;
    private String userName;
    private String examText;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Float score;
    private Boolean status;
    private List<UserAnswerDTO> listUserAnswerDTO;
    public ExamResultDTOResponse(Long examResultId, String userName, String examText, LocalDateTime startTime,
            LocalDateTime endTime, Float score, Boolean status) {
        ExamResultId = examResultId;
        this.userName = userName;
        this.examText = examText;
        this.startTime = startTime;
        this.endTime = endTime;
        this.score = score;
        this.status = status;
    }
    public Long getExamResultId() {
        return ExamResultId;
    }
    public void setExamResultId(Long examResultId) {
        ExamResultId = examResultId;
    }
    public LocalDateTime getStartTime() {
        return startTime;
    }
    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }
    public LocalDateTime getEndTime() {
        return endTime;
    }
    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }
    public Float getScore() {
        return score;
    }
    public void setScore(Float score) {
        this.score = score;
    }
    public Boolean getStatus() {
        return status;
    }
    public void setStatus(Boolean status) {
        this.status = status;
    }
    public List<UserAnswerDTO> getListUserAnswerDTO() {
        return listUserAnswerDTO;
    }
    public void setListUserAnswerDTO(List<UserAnswerDTO> listUserAnswerDTO) {
        this.listUserAnswerDTO = listUserAnswerDTO;
    }
}
