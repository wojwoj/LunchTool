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
//@NamedNativeQuery(name = "findUserByID", query = "select * from users s where s.id = :user_id", resultClass = User.class)
@NamedQuery(name = "findUserByLogin", query = "SELECT u from User u where u.login = :login")
public class User implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String name;
	private String surname;
	private String login;
	private String password;

	public String getLogin() {
		return login;
	}



	public void setLogin(String login) {
		this.login = login;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}

	@Id
	private Integer id;

	public User() {

	}

	





	public User(String name, String surname, String login, String password,
			Integer id) {
		super();
		this.name = name;
		this.surname = surname;
		this.login = login;
		this.password = password;
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
