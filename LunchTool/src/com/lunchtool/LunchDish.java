package com.lunchtool;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@Table(name = "LunchDishes")
@NamedQuery(name = "findLunchDishById", query = "SELECT ld from LunchDish ld where ld.id = :lunchDishId")
public class LunchDish implements Serializable {

	private static final long serialVersionUID = 1L;

	private String dishName;
	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	private int price;
	@Id
	private  int id;
	
	public LunchDish(){
		
	}
	
	public LunchDish(int id, String dishName, int price) {
		super();
		this.dishName = dishName;
		this.price = price;
		this.id=id;
	}

}
