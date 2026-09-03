package com.deepu.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;

@Entity
public class AnswerTable {
	@Id
	@Column(name = "ans_id")
	private Integer id;

	private String answer;

	@ManyToOne(cascade = CascadeType.ALL)
	private QuestionTable questionTable;

	public AnswerTable() {
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

	public QuestionTable getQuestionTable() {
		return questionTable;
	}

	public void setQuestionTable(QuestionTable questionTable) {
		this.questionTable = questionTable;
	}

	@Override
	public String toString() {
		return "AnswerTable [id=" + id + ", answer=" + answer + ", questionTable=" + questionTable + "]";
	}

}
