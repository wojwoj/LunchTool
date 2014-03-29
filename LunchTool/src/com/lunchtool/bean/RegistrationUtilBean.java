package com.lunchtool.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.lunchtool.RegistrationUtils;
import com.lunchtool.User;

@Stateless
public class RegistrationUtilBean implements RegistrationUtils {

	@PersistenceContext(unitName = "lunchtool")
	EntityManager em;
	
	public RegistrationUtilBean() {
	}

	@Override
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void registerUser(String name, String surname, String login,
			String password) {
		User user = new User(name, surname, login, password);
		em.persist(user);
	}


}
