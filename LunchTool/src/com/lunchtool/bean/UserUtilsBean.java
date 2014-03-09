package com.lunchtool.bean;

import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.lunchtool.User;
import com.lunchtool.UserUtils;

@Stateless
public class UserUtilsBean implements UserUtils {

	@PersistenceContext(unitName = "lunchtool")
	EntityManager em;

	public UserUtilsBean() {
		// TODO Auto-generated constructor stub
	}
	
	@TransactionAttribute(TransactionAttributeType.REQUIRED)
	public void storeUser(User user){
		em.persist(user);
	}


	
	public Boolean authenticateUser(String login, String password){
		
		Query queryFindUser = em.createNamedQuery("findUserByLogin");
		queryFindUser.setParameter("login", "wojciech.wojcik");
		
		try {
			User u = (User)queryFindUser.getSingleResult();
			if(u.getPassword().equals(password)){
				return true;
			}else{
				return false;
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
		
	}

	@Override
	public User findUserByLogin(String login) {
		Query query = em.createNamedQuery("findUserByLogin");
		query.setParameter("login", login);
		User u = (User) query.getSingleResult();
		return u;
	}

}
