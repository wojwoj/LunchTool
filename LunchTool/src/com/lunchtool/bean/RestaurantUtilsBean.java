package com.lunchtool.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lunchtool.LunchDish;
import com.lunchtool.LunchMenu;
import com.lunchtool.Order;
import com.lunchtool.Restaurant;
import com.lunchtool.RestaurantsUtils;
import com.lunchtool.User;


@Stateless
public class RestaurantUtilsBean implements RestaurantsUtils {

	@PersistenceContext(unitName = "lunchtool")
	EntityManager em;
	
	public RestaurantUtilsBean() {
		// TODO Auto-generated constructor stub
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addDishToMenu(LunchMenu menu, LunchDish dish) {
		LunchMenu menu2 = em.find(LunchMenu.class, menu.getId());
		if(menu2!=null){
			em.persist(dish);
			menu2.addLunchDishToMenu(dish);
		}else{
			em.persist(dish);
			menu.addLunchDishToMenu(dish);
			em.persist(menu);
		}
			
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addMenuToResturant(LunchMenu menu, Restaurant restaurant) {
		Restaurant restaurant2 = em.find(Restaurant.class, restaurant.getId());
		if(restaurant2!=null){
			em.persist(menu);
			restaurant2.setMenu(menu);
			System.out.println("nie ma takiej knajpy");
		}else{
			em.persist(menu);
		    restaurant.setMenu(menu);	
		    em.persist(restaurant);
		}
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addRestaurant(Restaurant restaurant) {
		em.persist(restaurant);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addOrder(User user, LunchDish dish) {
		em.persist(new Order(user, dish));
		
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public Restaurant getRestaurantById(int restaurantId) {
		Restaurant restaurant = em.find(Restaurant.class, restaurantId);
		return restaurant;	
	}

}
