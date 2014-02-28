package com.lunchtool;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "LunchMenus")
public class LunchMenu implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private int id;

	@OneToOne
	private Restaurant restaurant;
	@OneToMany
	private List<LunchDish> menu = new ArrayList<LunchDish>();

	public LunchMenu() {
	}

	public void addLunchDishToMenu(LunchDish dish) {
		menu.add(dish);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Restaurant getRestaurant() {
		return restaurant;
	}

	public void setRestaurant(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public List<LunchDish> getMenu() {
		return menu;
	}

	public void setMenu(List<LunchDish> menu) {
		this.menu = menu;
	}

}
