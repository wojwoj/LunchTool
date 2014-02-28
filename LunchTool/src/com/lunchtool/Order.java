package com.lunchtool;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Orders" )
public class Order {

	@Id
	private int id;
	@OneToOne
	private User user;
	@OneToOne
	private LunchDish dish;

	
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public LunchDish getDish() {
		return dish;
	}

	public void setDish(LunchDish dish) {
		this.dish = dish;
	}

	public Order(User user, LunchDish dish) {
		super();
		this.user = user;
		this.dish = dish;
	}

	public Order() {

	}

}
