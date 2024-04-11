package com.ltweb.onlinetest.services.imp;

import java.util.ArrayList;
import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ltweb.onlinetest.entities.Choice;
import com.ltweb.onlinetest.entities.Exam;
import com.ltweb.onlinetest.entities.Question;
import com.ltweb.onlinetest.models.ChoiceDTO.ChoiceDTO;
import com.ltweb.onlinetest.models.QuestionDTO.QuestionDTO;
import com.ltweb.onlinetest.repos.ChoiceRepository;
import com.ltweb.onlinetest.repos.ExamRepository;
import com.ltweb.onlinetest.repos.QuestionRepository;
import com.ltweb.onlinetest.services.QuestionService;

@Service
public class QuestionServiceImpl implements QuestionService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoiceRepository choiceRepository;
    @Override
    public Question getQuestionById(Long questionId) {
        return questionRepository.findById(questionId)
                                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Can't find question with id: " + questionId));
    }

    @Override
    public Long createQuestion(QuestionDTO questionDTO) {
        final Question question = mapToEntity(questionDTO, new Question());
        return question.getQuestionId();
    }

    @Override
    public void deleteQuestionById(Long questionId) {
        questionRepository.deleteById(questionId);
    }

    @Override
    public List<Question> findAllQuestions() {
        return questionRepository.findAll();
    }

    @Override
    public List<Question> findQuestionsByExamId(Long examId) {
        return questionRepository.findByExamExamId(examId);
    }

    public Question mapToEntity(QuestionDTO questionDTO, Question question) {
        question = modelMapper.map(questionDTO, Question.class);
        Exam exam = examRepository.findById(questionDTO.getExamId())
                                    .orElseThrow(()-> new RuntimeException("Exam id not found"));
        question.setExam(exam);
        // Thêm các lựa chọn mới
        List<ChoiceDTO> choiceDTOList = questionDTO.getListChoice();
        List<Choice> choiceList = new ArrayList<>();
        if (choiceDTOList != null) {
            for (ChoiceDTO choiceDTO : choiceDTOList) {
                Choice choice = new Choice();
                choice.setQuestion(question);
                choice.setChoiceText(choiceDTO.getChoiceText());
                choice.setCorrect(choiceDTO.isCorrect()); // Đặt giá trị isCorrect cho lựa chọn
                choiceList.add(choice);
            }
        }
        question.setListChoice(choiceList);
        
        // Lưu câu hỏi và các lựa chọn
        questionRepository.save(question);
        // choiceRepository.saveAll(choiceList);
        
        return question;
    }

    @Override
    public void updateQuestion(Long id, QuestionDTO questionDTO) {
        Question question = questionRepository.findById(id).orElseThrow(() -> new RuntimeException("Could not find this question"));
        question = mapToEntity(questionDTO, new Question());
    }

    
}
