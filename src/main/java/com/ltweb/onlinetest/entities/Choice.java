package com.ltweb.onlinetest.entities;


import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import lombok.Getter;
import lombok.Setter;

@Entity
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
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