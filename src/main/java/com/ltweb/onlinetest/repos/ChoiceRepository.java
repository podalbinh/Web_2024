package com.ltweb.onlinetest.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ltweb.onlinetest.entities.Choice;

@Repository
public interface ChoiceRepository extends JpaRepository<Choice, Long>{

}
