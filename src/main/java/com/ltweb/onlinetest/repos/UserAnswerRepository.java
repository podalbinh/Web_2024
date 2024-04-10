package com.ltweb.onlinetest.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltweb.onlinetest.entities.UserAnswer;
public interface UserAnswerRepository extends JpaRepository<UserAnswer,Long>{
    
}
