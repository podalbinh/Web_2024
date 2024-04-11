package com.ltweb.onlinetest.services.imp;

import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.models.ExamDTO;
import com.ltweb.onlinetest.repos.ExamRepository;
import com.ltweb.onlinetest.services.ExamService;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class ExamServiceImpl implements ExamService {

    private final ExamRepository examRepository;
    private final ModelMapper modelMapper;

    public ExamServiceImpl(ExamRepository examRepository, ModelMapper modelMapper) {
        this.examRepository = examRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public Long createExam(ExamDTO examDTO) {
        final Exam exam = mapToEntity(examDTO, new Exam());
        return examRepository.save(exam).getExamId();
    }

    @Override
    public Exam getExamById(Long examId) {
        return examRepository.findById(examId)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find exam with id: " + examId));
    }

    @Override
    public void saveOrUpdateExam(ExamDTO examDTO) {
        Exam exam = mapToEntity(examDTO, new Exam());
        examRepository.save(exam);
    }

    @Override
    public void deleteExam(Long examId) {
        examRepository.deleteById(examId);
    }

    public Exam mapToEntity(ExamDTO examDTO, Exam exam) {
        exam = modelMapper.map(examDTO, Exam.class);
        examRepository.save(exam);
        return exam;
    }

    @Override
    public List<Exam> findAll() {
        return examRepository.findAll();
    }
}
