package com.lunchtool;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.NamedQueries;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.caucho.quercus.env.Value;

import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "Orders" )

@NamedQueries({
	 @NamedQuery(name ="findAllOrdersByUserId", 
	          query = "SELECT o from Order o where o.user.id = :userId"),
	 @NamedQuery(name = "removeTodaysOrdersForUser",   query = "DELETE FROM Order s WHERE s.date < :today")
	          })
public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFILE_ID_GEN")
	@SequenceGenerator(name = "PROFILE_ID_GEN", sequenceName = "PROFILE_ID_SEQ")
	private int id;
	@OneToOne(fetch = FetchType.EAGER)
	private User user;
	@OneToOne(fetch = FetchType.EAGER)
	private LunchDish dish;
	
	private Date date;

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
		this.date=new Date();
	}

	public Order() {

	}

	public Value serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	public Value unserialize(Value arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
