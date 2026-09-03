package com.deepu.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;

@Entity
public class Answer 
{
	@Id
	@Column(name="answer_id")
	private Integer id;
	
	@Column(name="answer")
	private String answer;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Question question;
	
	
	

	public Answer() {
		System.out.println("zero param constructor of Answer");
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	public Question getQuestion() {
		return question;
	}
	public void setQuestion(Question question) {
		this.question = question;
	}
	
	@Override
	public String toString() {
		return "Answer [id=" + id + ", answer=" + answer + "]";
	}

}
