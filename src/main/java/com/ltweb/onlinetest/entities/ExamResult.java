package com.ltweb.onlinetest.entities;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.*;

@Entity
@Table(name = "examResults")
public class ExamResult {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "examResultId")
    private Long ExamResultId;

    @ManyToOne
    @JoinColumn(name = "userId", nullable = false)
    private User user;

    @ManyToOne
    @JoinColumn(name = "examId", nullable = false)
    private Exam exam;

    @Column(name = "startTime")
    private LocalDateTime startTime;

    @Column(name = "endTime")
    private LocalDateTime endTime;

    @Column(name = "score")
    private Float score;

    @Column(name = "status", nullable = false)
    private Boolean status;

    @OneToMany(mappedBy = "examResult")
    private List<UserAnswer> listUserAnswer;
}