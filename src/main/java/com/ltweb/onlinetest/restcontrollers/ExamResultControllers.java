package com.ltweb.onlinetest.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.entities.ExamResult;
import com.ltweb.onlinetest.entities.UserAnswer;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTO;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTOAll;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTOResponse;
import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTO;
import com.ltweb.onlinetest.services.ExamResultService;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value = "/api/v1/examresult", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamResultControllers {
    @Autowired
    private ExamResultService examResultService;
    @GetMapping("/all")
    public ResponseEntity<?> getAll() {
        List<ExamResult> list=examResultService.findAll();
        List<ExamResultDTOAll> listDTO=new ArrayList<>();
        for(ExamResult i: list){
            listDTO.add(new ExamResultDTOAll(
                i.getExamResultId(),i.getUser().getUsername(),i.getExam().getExamName(),i.getExam().getExamType().toString(),i.getStartTime(),i.getEndTime(),i.getScore()));
        }
        return ResponseEntity.ok(listDTO);
    }
    @GetMapping("/{id}")
    public ResponseEntity<?> getExamResult(@PathVariable final Long id) {
        ExamResult examResult=examResultService.findById(id);
        ExamResultDTOResponse examResultResponseDTO=new ExamResultDTOResponse(examResult.getExamResultId(),
            examResult.getUser().getUsername(),examResult.getExam().getExamName(),examResult.getStartTime(),examResult.getStartTime(),
            examResult.getScore(),examResult.getStatus());
            List<UserAnswerDTO> list=new ArrayList<>();
        for(UserAnswer i: examResult.getListUserAnswer()){
           list.add(new UserAnswerDTO(i.getUserAnswerId(), i.getQuestion().getQuestionText(), i.getChoice().getChoiceText(), i.getChoice().isCorrect()));
        }
        examResultResponseDTO.setListUserAnswerDTO(list);
        return ResponseEntity.ok(examResultResponseDTO);
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> requestMethodName(@PathVariable final Long id) {
            examResultService.delete(id);
        return ResponseEntity.noContent().build();
    }
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody final ExamResultDTO examResultDTO) {   
        return ResponseEntity.ok(examResultService.create(examResultDTO));
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<?> getExamResultByUserId(@PathVariable final Long id) {
        List<ExamResult> listExamResult=examResultService.findByUserId(id);
        List<ExamResultDTOAll> listDTO=new ArrayList<>();
        for(ExamResult i: listExamResult){
            listDTO.add(new ExamResultDTOAll(
                i.getExamResultId(),i.getUser().getUsername(),i.getExam().getExamName(),i.getExam().getExamType().toString(),i.getStartTime(),i.getEndTime(),i.getScore()));
        }
    return ResponseEntity.ok(listDTO);
    }
    @GetMapping("/exam/{id}")
    public ResponseEntity<?> getExamResultByExamId(@PathVariable final Long id) {
        List<ExamResult> listExamResult=examResultService.findByExamId(id);
        List<ExamResultDTOAll> listDTO=new ArrayList<>();
        for(ExamResult i: listExamResult){
            listDTO.add(new ExamResultDTOAll(
                i.getExamResultId(),i.getUser().getUsername(),i.getExam().getExamName(),i.getExam().getExamType().toString(),i.getStartTime(),i.getEndTime(),i.getScore()));
        }
    return ResponseEntity.ok(listDTO);
    }
    
}
