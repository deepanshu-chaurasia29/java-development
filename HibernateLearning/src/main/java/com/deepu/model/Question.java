package com.deepu.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;


@Entity
public class Question 
{
	@Id
	@Column(name="question_id")
	private Integer id;
	
	@Column(name="question")
	private String question;
	
	@OneToOne(cascade=CascadeType.ALL)
	private Answer answer;
	
	public Question(){
		System.out.println("zero param constructor of Question");
	}
	

	public Question(Integer id, String question) {
		this.id = id;
		this.question = question;
	}


	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Answer getAnswer() {
		return answer;
	}

	public void setAnswer(Answer answer) {
		this.answer = answer;
	}

	@Override
	public String toString() {
		return "Question [id=" + id + ", question=" + question + ", answer=" + answer + "]";
	}
	
	

}
