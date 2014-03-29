package com.lunchtool;
import java.util.List;



public interface OrderUtils {
	
	public void addOrder(Integer lunchId, User user);
	public List<Order> getOrdersByUsedId(int userId);
	public List<LunchDish> getOrderedLunchDishes(List<Order> orders);
	public void removeTodaysOrdersForUser(int user);
	
}
