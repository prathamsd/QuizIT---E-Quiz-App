package com.codered.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codered.main.model.Question;

@Repository
public interface QuestionRepo extends JpaRepository<Question, Integer> 
{
	
}