package com.deepu.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.SequenceGenerator;

@Entity
public class StudentInfo 
{
	public StudentInfo() {
	}

	@Id
	@GeneratedValue(generator="my_seq",strategy=GenerationType.IDENTITY)  // it auto increment id
	@SequenceGenerator(name="my_seq",sequenceName="my_own_sequence",initialValue=100,allocationSize=1)  // id starting value will be 100 becasue i gave it sequence
	@Column(name="std_id")
	private Integer id;
	
	@Column(name="std_name")
	private String name;
	
	@Lob
	@Column(length=10000000)  // specify the length of the photo column
	private byte[] photo;  // student photo will be stored in byte array
	
	@Lob
	@Column(length=1000000)  // specify the length of the resume column
	private char[] resume;  // student resume will be stored in char array

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

	public char[] getResume() {
		return resume;
	}

	public void setResume(char[] resume) {
		this.resume = resume;
	}

	@Override
	public String toString() {
		return "StudentInfo [id=" + id + ", name=" + name + ", photo=" + photo + ", resume=" + resume + "]";
	}

}
