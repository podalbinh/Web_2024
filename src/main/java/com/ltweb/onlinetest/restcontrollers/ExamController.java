package com.ltweb.onlinetest.restcontrollers;

import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.models.ExamDTO;
import com.ltweb.onlinetest.services.ExamService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;   

import java.util.List;

@RestController
@RequestMapping("/api/v1/exams")
public class ExamController {

    private final ExamService examService;

    public ExamController(ExamService examService) {
        this.examService = examService;
    }
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")    
    public ResponseEntity<Long> createExam(@RequestBody ExamDTO examDTO) {
        return ResponseEntity.ok(examService.createExam(examDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamById(id);
        return ResponseEntity.ok(exam);
    }
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> saveOrUpdateExam(@PathVariable Long id, @RequestBody ExamDTO examDTO) {
        examDTO.setExamId(id);
        examService.saveOrUpdateExam(examDTO);
        return ResponseEntity.ok("Cập nhật kì thi thành công!");
    }
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.ok("Xóa kì thi thành công!");
    }
    
    @GetMapping("/all")
    public ResponseEntity<List<Exam>> getAllExam() {
        List<Exam> exams = examService.findAll();
        return ResponseEntity.ok(exams);
    }
}
