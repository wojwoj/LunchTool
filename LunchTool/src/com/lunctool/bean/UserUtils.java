package com.lunctool.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lunchtool.User;

@Stateless
public class UserUtils {

	@PersistenceContext(unitName = "lunchtool")
	EntityManager em;

	public UserUtils() {
		// TODO Auto-generated constructor stub
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void storeUser(User user){
		em.persist(user);
	}

	public String findUser() {

		Query query = em.createNamedQuery("findUserrByID");
		query.setParameter("id", 6733);
		String u = (String) query.getSingleResult();
		return u;
	}

}
