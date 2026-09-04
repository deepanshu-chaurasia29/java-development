package com.deepu.model;

import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;

@Entity
public class Students {

	@Id
	@Column(name = "std_id")
	private Integer Id;

	@Column(name = "std_name")
	private String name;

	@Column(name = "std_city")
	private String city;

	@ManyToMany(cascade = CascadeType.ALL)
	private Set<Courses> courses;

	
	
	public Set<Courses> getCourses() {
		return courses;
	}

	public void setCourses(Set<Courses> courses) {
		this.courses = courses;
	}

	public Students() {
		System.out.println("zero arg constructor");
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "[name=" + name + ",courses=" + courses + "]";
	}

}
