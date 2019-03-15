/*
*
* (C) Copyright 2019Fresher Academy
* Author apple
* Date Mar 6, 2019
* Version 1.0
*
*/
package com.fpt.excercise1.model;

public class Author {

	private String name;
	private String email;
	private char gender;
	
	public Author() {
		// TODO Auto-generated constructor stub
	}

	public Author(String name, String email, char gender) {
		super();
		this.name = name;
		this.email = email;
		this.gender = gender;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public char getGender() {
		return gender;
	}

	public void setGender(char gender) {
		this.gender = gender;
	}

	
	
}
