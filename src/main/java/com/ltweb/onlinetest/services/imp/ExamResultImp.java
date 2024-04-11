package com.ltweb.onlinetest.services.imp;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com.ltweb.onlinetest.entities.ExamResult;
import com.ltweb.onlinetest.entities.Question;
import com.ltweb.onlinetest.entities.UserAnswer;
import com.ltweb.onlinetest.models.examresultDTO.ExamResultDTO;
import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTO;
import com.ltweb.onlinetest.models.useranswerDTO.UserAnswerDTORequest;
import com.ltweb.onlinetest.repos.ChoiceRepository;
import com.ltweb.onlinetest.repos.ExamResultRepository;
import com.ltweb.onlinetest.repos.QuestionRepository;
import com.ltweb.onlinetest.repos.UserAnswerRepository;
import com.ltweb.onlinetest.repos.UserRepository;
import com.ltweb.onlinetest.services.ExamResultService;
import com.ltweb.onlinetest.repos.ExamRepository;
import com.ltweb.onlinetest.entities.User;
import com.ltweb.onlinetest.entities.Choice;
import com.ltweb.onlinetest.entities.Exam;
@Service
public class ExamResultImp implements ExamResultService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private ExamResultRepository examResultRepository;
    @Autowired
    private UserAnswerRepository userAnswerRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private ExamRepository examRepository;
    @Autowired
    private QuestionRepository questionRepository;
    @Autowired
    private ChoiceRepository choiceRepository;
    @Override
    public ExamResult findById(Long id) {
        return examResultRepository.findById(id) .orElseThrow(
            () -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cannot find ExamResult with id: " + id));
    }
    @Override
    public Long create (ExamResultDTO examResultDTO){
        final ExamResult examResult = mapToEntity(examResultDTO, new ExamResult());
        return examResultRepository.save(examResult).getExamResultId();
    }
    @Override
    public void delete(Long id){
        examResultRepository.deleteById(id);;
    }
    public ExamResult mapToEntity(ExamResultDTO examResultDTO,ExamResult examResult){
        examResult = modelMapper.map(examResultDTO, ExamResult.class);
        Exam exam= examRepository.findById(examResultDTO.getExamId()) .orElseThrow(() -> new RuntimeException("Exam Id "+examResultDTO.getExamId()+"is not found"));
        User user= userRepository.findById(examResultDTO.getUserId()) .orElseThrow(() -> new RuntimeException("User Id "+examResultDTO.getUserId()+"is not found"));
        examResult.setExam(exam);
        examResult.setUser(user);
        examResultRepository.save(examResult);
        for(UserAnswerDTORequest i: examResultDTO.getListUserAnswerDTO()){
            UserAnswer userAnswer =new UserAnswer();
            Choice choice= choiceRepository.findById(i.getChoiceId()).orElseThrow(() -> new RuntimeException("Choice Id "+i.getChoiceId()+"is not found"));
            Question question =questionRepository.findById(i.getQuestionId()).orElseThrow(() -> new RuntimeException("Question Id "+i.getQuestionId()+"is not found"));
            userAnswer.setExamResult(examResult);
            userAnswer.setChoice(choice);
            userAnswer.setQuestion(question);
            userAnswerRepository.save(userAnswer);
        }
        return examResult;
    }
    public List<ExamResult> findAll(){
        return examResultRepository.findAll();
    }
    @Override
    public List<ExamResult> findByUserId(Long id) {
        return examResultRepository.findByUserId(id);
    }
    @Override
    public List<ExamResult> findByExamId(Long id) {
        return examResultRepository.findByExamExamId(id);
    }
}
