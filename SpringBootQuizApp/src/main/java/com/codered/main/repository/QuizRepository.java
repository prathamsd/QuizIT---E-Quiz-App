package com.codered.main.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.codered.main.model.Quiz;

@Repository
public interface QuizRepository extends JpaRepository<Quiz, Integer>
{
	public List<Quiz> findAll();
}
