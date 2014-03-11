package com.lunchtool;
import javax.jws.soap.SOAPBinding.Use;

public interface RestaurantsUtils {
	public void addDishToMenu(LunchMenu menu, LunchDish dish); 
	public void addMenuToResturant(LunchMenu menu, Restaurant restaurant);
	public void addRestaurant(Restaurant restaurant);
	public void addOrder(User user, LunchDish dish);

}
