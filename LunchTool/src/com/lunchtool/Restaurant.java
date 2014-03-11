package com.lunchtool;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Restaurants")

public class Restaurant implements Serializable {

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant(int id) {
		super();
		this.id = id;
	}

	private static final long serialVersionUID = 1L;
	
	@Id
	private int id;
	
	private String name;

	@OneToOne
	private LunchMenu menu;
	
	public LunchMenu getMenu() {
		return menu;
	}

	public void setMenu(LunchMenu menu) {
		this.menu = menu;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
    
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

	public Restaurant(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public Restaurant(int id, String name, LunchMenu menu) {
		super();
		this.id = id;
		this.name = name;
		this.menu = menu;
	}
	

}
