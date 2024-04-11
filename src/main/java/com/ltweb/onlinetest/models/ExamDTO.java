package com.ltweb.onlinetest.models;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data 
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ExamDTO {
    private Long examId;
    private String examName;
    private String description;
    private String examType;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private Long timeToDo;
}
