package com.ltweb.onlinetest.repos;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ltweb.onlinetest.entities.Choice;

public interface ChoiceRepository extends JpaRepository<Choice,Long> {
    public Optional<Choice> findById(Long choiceId);
    public void deleteById(Long choiceId);
}