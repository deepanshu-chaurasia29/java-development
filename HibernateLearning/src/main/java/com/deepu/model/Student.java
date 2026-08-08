package com.deepu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="StudentTable")
public class Student 
{
	@Id
	@Column(name="SID")
	private Integer sId;
	
	@Column(name="SNAME")
	private String sName;
	
	@Column(name="SCITY")
	private String sCity;
	
	public Student(Integer sId, String sName, String sCity) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.sCity = sCity;
	}

	public Student(){
		System.out.println("Student class constructor");
	}

	public Integer getsId() {
		return sId;
	}

	public void setsId(Integer sId) {
		this.sId = sId;
	}

	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	@Override
	public String toString() {
		return "Student [sId=" + sId + ", sName=" + sName + ", sCity=" + sCity + "]";
	}

	public String getsCity() {
		return sCity;
	}

	public void setsCity(String sCity) {
		this.sCity = sCity;
	}
	
	
	
	
}
