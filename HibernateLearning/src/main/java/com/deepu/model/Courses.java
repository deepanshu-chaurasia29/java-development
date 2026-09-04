package com.deepu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Courses {
	
	@Id
	@Column(name = "course_id")
	private Integer id;

	@Column(name = "course_name")
	private String courseName;
	
	@Column(name = "course_price")
	private String coursePrice;
	
	

	public Courses() {
		System.out.println("zero arg constructor of Courses");
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getCoursePrice() {
		return coursePrice;
	}

	public void setCoursePrice(String coursePrice) {
		this.coursePrice = coursePrice;
	}
	@Override
	public String toString() {
		return "[Courses : courseName="+ courseName + "]";
	}

	

}
