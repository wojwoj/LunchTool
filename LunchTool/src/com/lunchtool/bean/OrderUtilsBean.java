package com.lunchtool.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lunchtool.LunchDish;
import com.lunchtool.Order;
import com.lunchtool.OrderUtils;
import com.lunchtool.User;

@Stateless
public class OrderUtilsBean implements OrderUtils {

	@PersistenceContext(unitName = "lunchtool")
	EntityManager em;

	public OrderUtilsBean() {

	}

	public static void main(String[] args) {

	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void addOrder(Integer lunchId, User user) {
		Query query = em.createNamedQuery("findLunchDishById");
		query.setParameter("lunchDishId", lunchId);
		LunchDish ld = (LunchDish) query.getSingleResult();
		Order order = new Order(user, ld);
		em.persist(order);
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<Order> getOrdersByUsedId(int userId) {
		Query query = em.createNamedQuery("findAllOrdersByUserId");
		query.setParameter("userId", userId);
		List<Order> result = (List<Order>)query.getResultList();
		return result;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public List<LunchDish> getOrderedLunchDishes(List<Order> orders) {
		Query query = em.createNamedQuery("findLunchDishById");
		
		List<LunchDish> result;
		
//		for (Order order :orders){
//			query.setParameter("lunchDishId", order.getDish().getId());
//			result
//		}
		
		return null;
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void removeTodaysOrdersForUser(int user) {
		Query query = em.createNamedQuery("removeTodaysOrdersForUser");
		query.setParameter("today", new Date());
		query.executeUpdate();
		
	}

}
