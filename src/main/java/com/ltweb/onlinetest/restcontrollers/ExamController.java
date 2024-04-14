package com.ltweb.onlinetest.restcontrollers;

import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.models.ExamDTO;
import com.ltweb.onlinetest.services.ExamService;

import io.swagger.v3.oas.annotations.Operation;

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
    
    @Operation(summary = "Create Exam")
    @PostMapping
    @PreAuthorize("hasRole('ROLE_ADMIN')")    
    public ResponseEntity<Long> createExam(@RequestBody ExamDTO examDTO) {
        return ResponseEntity.ok(examService.createExam(examDTO));
    }
    @Operation(summary = "Get Exam by ID")
    @GetMapping("/{id}")
    public ResponseEntity<Exam> getExamById(@PathVariable Long id) {
        Exam exam = examService.getExamById(id);
        return ResponseEntity.ok(exam);
    }
    @Operation(summary = "Update Exam by ID")
    @PreAuthorize("hasRole('ROLE_ADMIN')")
    @PutMapping("/{id}")
    public ResponseEntity<String> saveOrUpdateExam(@PathVariable Long id, @RequestBody ExamDTO examDTO) {
        examDTO.setExamId(id);
        examService.saveOrUpdateExam(examDTO);
        return ResponseEntity.ok("Cập nhật kì thi thành công!");
    }
    @Operation(summary = "Delete Exam")
    @PreAuthorize("hasRole('ROLE_ADMIN') or hasRole('ROLE_MODERATOR')")
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteExam(@PathVariable Long id) {
        examService.deleteExam(id);
        return ResponseEntity.ok("Xóa kì thi thành công!");
    }
    @Operation(summary = "Get all Exam")
    @GetMapping("/all")
    public ResponseEntity<List<Exam>> getAllExam() {
        List<Exam> exams = examService.findAll();
        return ResponseEntity.ok(exams);
    }
    @Operation(summary = "Search Exam")
    @GetMapping("/searchExam")
    public ResponseEntity<List<Exam>> searchExam(@RequestParam("query") String query) {
        return ResponseEntity.ok(examService.searchExam(query));
    }
}
