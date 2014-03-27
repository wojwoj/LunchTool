package com.lunchtool.bean;

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
		Order order = new Order(user,ld);
		em.persist(order);
	}

}
