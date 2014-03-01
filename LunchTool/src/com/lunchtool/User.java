package com.lunchtool;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
//@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "Users")
@NamedNativeQuery(name = "findUserByID", query = "select * from users s where s.id = :user_id", resultClass = User.class)
@NamedQuery(name = "findUserrByID", query = "SELECT u.name from User u where u.id = :id")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;

	@Id
	private Integer id;

	public User() {

	}

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
