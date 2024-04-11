package com.ltweb.onlinetest.restcontrollers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ltweb.onlinetest.entities.Choice;
import com.ltweb.onlinetest.entities.Question;
import com.ltweb.onlinetest.models.ChoiceDTO.ChoiceDTO;
import com.ltweb.onlinetest.models.QuestionDTO.QuestionDTO;
import com.ltweb.onlinetest.models.QuestionDTO.QuestionDTOAll;
import com.ltweb.onlinetest.models.QuestionDTO.QuestionDTOResponse;
import com.ltweb.onlinetest.services.QuestionService;

@RestController
@RequestMapping("/api/v1/questions")
public class QuestionController {
    @Autowired 
    private QuestionService questionService;
    @GetMapping("/{id}")
    public ResponseEntity<?> getQuestionById(@PathVariable Long id) {
        Question question = questionService.getQuestionById(id);
        QuestionDTOResponse questionDTOResponse = new QuestionDTOResponse(
            question.getQuestionId(),
            question.getExam().getExamName(),
            question.getQuestionText()
        );
        List<ChoiceDTO> list = new ArrayList<>();
        for(Choice i : question.getListChoice()) {
            list.add(new ChoiceDTO(i.getChoiceId(), i.getChoiceText(), i.isCorrect(), i.getQuestion().getQuestionId()));
        }
        questionDTOResponse.setListChoice(list);
        return ResponseEntity.ok(questionDTOResponse);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PostMapping
    public ResponseEntity<Long> createQuestion(@RequestBody QuestionDTO questionDTO) {
        return ResponseEntity.ok(questionService.createQuestion(questionDTO));
    }
    @PreAuthorize(" hasRole('ROLE_ADMIN')")
    @DeleteMapping("/{id}") 
    public ResponseEntity<String> deleteQuestion(@PathVariable Long id) {
        questionService.deleteQuestionById(id);
        return ResponseEntity.ok("Xóa câu hỏi hiện tại thành công!");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> updateQuestion(@PathVariable Long id, @RequestBody QuestionDTO questionDTO) {
        questionDTO.setQuestionId(id);
        questionService.updateQuestion(id, questionDTO);
        return ResponseEntity.ok("Cập nhật câu hỏi thành công!");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @GetMapping("/all")
    public ResponseEntity<List<Question>> getAllQuestions() {
        List<Question> questions = questionService.findAllQuestions();
        return ResponseEntity.ok(questions);
    }

    @GetMapping("/exam/{id}")
    public ResponseEntity<?> getQuestionByExamId(@PathVariable Long id) {
        List<Question> questions = questionService.findQuestionsByExamId(id);
        List<QuestionDTOAll> listDTOAll = new ArrayList<>();
        for(Question i: questions) {
            listDTOAll.add(new QuestionDTOAll(
                i.getQuestionId(),
                i.getExam().getExamName(),
                i.getQuestionText()
            ));
        }
        return ResponseEntity.ok(listDTOAll);
    }
}
