package com.ltweb.onlinetest.restcontrollers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.entities.ExamResult;
import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.entities.UserAnswer;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTO;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTOAll;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTOResponse;
import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTO;
import com.ltweb.onlinetest.payload.response.MessageResponse;
import com.ltweb.onlinetest.security.AuthService;
import com.ltweb.onlinetest.services.ExamResultService;
import com.ltweb.onlinetest.services.UserService;

import io.swagger.v3.oas.annotations.Operation;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;



@RestController
@RequestMapping(value = "/api/v1/examresult", produces = MediaType.APPLICATION_JSON_VALUE)
public class ExamResultControllers {
    @Autowired
    private ExamResultService examResultService;
    @Autowired
    private AuthService authService;

    @Operation(summary = "Get all ExamResult")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
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
    @Operation(summary = "Get ExamResult By Id")
    @PreAuthorize("hasRole('ROLE_USER') or hasRole('ROLE_ADMIN')")
    @GetMapping("/{id}")
    public ResponseEntity<?> getExamResultById(@PathVariable final Long id) {
        ExamResult examResult=examResultService.findById(id);
        if(!examResult.getUser().getId().equals(authService.getCurrentUserId())){
            return ResponseEntity.badRequest().body(new MessageResponse("You do not have access here"));
        }        
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
    @Operation(summary = "Create ExamResult (User)")
    @PreAuthorize("hasRole('ROLE_USER')")
    @PostMapping
    public ResponseEntity<Long> create(@RequestBody final ExamResultDTO examResultDTO) {   
        return ResponseEntity.ok(examResultService.create(examResultDTO));
    }
    @Operation(summary = "Get all ExamResult By currentUser")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users")
    public ResponseEntity<?> getAllExamResultByCurrentUser() {
    List<ExamResult> listExamResult = examResultService.findByUserId(authService.getCurrentUserId());
    List<ExamResultDTOAll> listDTO = new ArrayList<>();
    for (ExamResult i : listExamResult) {
        listDTO.add(new ExamResultDTOAll(
            i.getExamResultId(), i.getUser().getUsername(), i.getExam().getExamName(), 
            i.getExam().getExamType().toString(), i.getStartTime(), i.getEndTime(), i.getScore()));
    }
    return ResponseEntity.ok(listDTO);
}
// Xem tất cả các kết quả kiểm tra của một bài kiểm tra
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Get all ExamResult By examId")
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
    @Operation(summary = "Get all ExamResult with current User By examId")
    @PreAuthorize("hasRole('ROLE_USER')")
    @GetMapping("/users/exam/{id}")
    public ResponseEntity<?> getExamResultByExamIdAndUserId(@PathVariable final Long id) {
        List<ExamResult> listExamResult=examResultService.findByExamIdAndUserId(id,authService.getCurrentUserId());
        List<ExamResultDTOAll> listDTO=new ArrayList<>();
        for(ExamResult i: listExamResult){
            listDTO.add(new ExamResultDTOAll(
                i.getExamResultId(),i.getUser().getUsername(),i.getExam().getExamName(),i.getExam().getExamType().toString(),i.getStartTime(),i.getEndTime(),i.getScore()));
        }
        return ResponseEntity.ok(listDTO);
    }
    @Operation(summary = "Delete ExamResult and UserAnswer")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable final Long id){
        examResultService.delete(id);
       return ResponseEntity.ok().body(new MessageResponse("Delete success!"));
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "Top 10 User most score")
    @GetMapping("/top")
    public ResponseEntity<?> getTop10ExamResultByExamId(@RequestParam("examId")Long examId) {
        List<ExamResult> list=examResultService.Top10ExamResult(examId);
        List<ExamResultDTOAll> listDTO=new ArrayList<>();
        for(ExamResult i: list){
            listDTO.add(new ExamResultDTOAll(
                i.getExamResultId(),i.getUser().getUsername(),i.getExam().getExamName(),i.getExam().getExamType().toString(),i.getStartTime(),i.getEndTime(),i.getScore()));
        }
        return ResponseEntity.ok(listDTO);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @Operation(summary = "statistic")
    @GetMapping("/statistic")
    public ResponseEntity<?> statistic(@RequestParam("examId")Long examId) {
        return ResponseEntity.ok(examResultService.state(examId));
    }
    
}
