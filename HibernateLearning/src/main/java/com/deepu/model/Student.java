package com.deepu.model;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

import jakarta.persistence.Cacheable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;


@Entity
@Table(name="StudentTable")
@Cacheable   // this assosciate this entity with 2L caching
@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)
public class Student 
{
	@Id
	@GeneratedValue(generator="my_seq",strategy=GenerationType.IDENTITY)  // it auto increment id
	@SequenceGenerator(name="my_seq",sequenceName="my_own_sequence",initialValue=100,allocationSize=1)  // id starting value will be 100 becasue i gave it sequence
	@Column(name="SID")
	private Integer sId;
	
	@Column(name="SNAME")
	private String sName;
	
	@Column(name="SCITY")
	private String sCity;
	

	public Student(String sName, String sCity) {
		super();
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
