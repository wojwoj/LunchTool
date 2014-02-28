package com.lunchtool;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LunchDishes")
public class LunchDish implements Serializable {

	private static final long serialVersionUID = 1L;

	String dishName;
	int price;
	@Id
	long id;
	
	public LunchDish(){
		
	}
	
	public LunchDish(long id, String dishName, int price) {
		super();
		this.dishName = dishName;
		this.price = price;
		this.id=id;
	}

}
