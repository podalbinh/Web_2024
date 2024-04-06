package com.ltweb.onlinetest.entities;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name = "userAnswers")
public class UserAnswer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "userAnswerId")
    private Long userAnswerId;

    @ManyToOne
    @JoinColumn(name = "examResultId", nullable = false)
    private ExamResult examResult;

    @JsonIgnoreProperties("listChoice")
    @ManyToOne
    @JoinColumn(name = "questionId", nullable = false)
    private Question question;

    @ManyToOne
    @JoinColumn(name = "choiceId")
    private Choice choice;
}