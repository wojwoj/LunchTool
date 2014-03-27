package com.lunchtool;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import com.caucho.quercus.env.Value;
import com.caucho.quercus.lib.spl.Serializable;

@Entity
@Table(name = "Orders" )

public class Order implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "PROFILE_ID_GEN")
	@SequenceGenerator(name = "PROFILE_ID_GEN", sequenceName = "PROFILE_ID_SEQ")
	private int id;
	@OneToOne
	private User user;
	@OneToOne
	private LunchDish dish;

	
	
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
	}

	public Order() {

	}

	@Override
	public Value serialize() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Value unserialize(Value arg0) {
		// TODO Auto-generated method stub
		return null;
	}

}
