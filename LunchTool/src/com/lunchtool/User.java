package com.lunchtool;

public class User {

	private String name;
	private String surname;
	private Integer id;
	public User(String name, String surname, Integer id) {
		super();
		this.name = name;
		this.surname = surname;
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSurname() {
		return surname;
	}
	public void setSurname(String surname) {
		this.surname = surname;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
}
