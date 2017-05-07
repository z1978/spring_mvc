package com.sample.business.model;

import java.util.Date;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Range;

	

	

public class User {
	@NotNull
	@Size(min=3,max=3)
	private String id;
	
	@NotNull
	@Size(min=1)
	private String name;

	

	@NotNull
	@Range(min=10, max=99)
	private int age;
	
	private Date upDate; //更新日
		  
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Date getUpDate() {
		return upDate;
	}
	public void setUpDate(Date upDate) {
		this.upDate = upDate;
	}
}