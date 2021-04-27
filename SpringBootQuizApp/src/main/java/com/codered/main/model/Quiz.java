package com.codered.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "quiz")
public class Quiz 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int quiz_id;
	private String quiz_key;
	private String quiz_name;
	private int login_id;
	
	public Quiz() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Quiz(int quiz_id, String quiz_key, String quiz_name, int login_id) {
		super();
		this.quiz_id = quiz_id;
		this.quiz_key = quiz_key;
		this.quiz_name = quiz_name;
		this.login_id = login_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	public String getQuiz_key() {
		return quiz_key;
	}

	public void setQuiz_key(String quiz_key) {
		this.quiz_key = quiz_key;
	}

	public String getQuiz_name() {
		return quiz_name;
	}

	public void setQuiz_name(String quiz_name) {
		this.quiz_name = quiz_name;
	}

	public int getLogin_id() {
		return login_id;
	}

	public void setLogin_id(int login_id) {
		this.login_id = login_id;
	}

	@Override
	public String toString() {
		return "Quiz [quiz_id=" + quiz_id + ", quiz_key=" + quiz_key + ", quiz_name=" + quiz_name + ", login_id="
				+ login_id + "]";
	}

	
	
}
