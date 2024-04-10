package com.ltweb.onlinetest.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "userAnswers")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userAnswerId")
    private Long userAnswerId;

    @ManyToOne
    @JoinColumn(name = "examResultId", nullable = false)
    private ExamResult examResult;

    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    @JsonIgnoreProperties("listChoice")
    private Question question;

    @ManyToOne
    @JoinColumn(name = "choiceId")
    private Choice choice;
}