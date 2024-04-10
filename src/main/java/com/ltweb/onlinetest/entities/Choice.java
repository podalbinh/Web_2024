package com.ltweb.onlinetest.entities;

import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "choices")
public class Choice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "choiceId")
    private Long choiceId;


    @Column(name = "choiceText")
    private String choiceText;

    @Column(name = "isCorrect")
    private boolean isCorrect;
    @ManyToOne
    @JoinColumn(name = "questionID", nullable = false)
    private Question question;
}