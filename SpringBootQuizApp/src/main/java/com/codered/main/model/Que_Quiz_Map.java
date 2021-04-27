package com.codered.main.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name = "que_quiz_map")
public class Que_Quiz_Map 
{
	@Id
	private int que_id;
	
	private int quiz_id;

	public Que_Quiz_Map() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Que_Quiz_Map(int que_id, int quiz_id) {
		super();
		this.que_id = que_id;
		this.quiz_id = quiz_id;
	}

	public int getQue_id() {
		return que_id;
	}

	public void setQue_id(int que_id) {
		this.que_id = que_id;
	}

	public int getQuiz_id() {
		return quiz_id;
	}

	public void setQuiz_id(int quiz_id) {
		this.quiz_id = quiz_id;
	}

	@Override
	public String toString() {
		return "Que_Quiz_Map [que_id=" + que_id + ", quiz_id=" + quiz_id + "]";
	}
	
	

}
