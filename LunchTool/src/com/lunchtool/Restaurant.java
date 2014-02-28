package com.lunchtool;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
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
	
	public Restaurant() {
		// TODO Auto-generated constructor stub
	}

}
