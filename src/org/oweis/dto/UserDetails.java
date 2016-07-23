package org.oweis.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CollectionId;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int userId;
	@Column (name="USER_NAME")
	private String userName;
	@OneToMany
	@JoinTable(name="User_Vehicule",joinColumns=@JoinColumn(name="User_id"),inverseJoinColumns=@JoinColumn(name="Vehicule_id"))
	private Collection<Vehicule> vehicule = new ArrayList<Vehicule>();
	
	public UserDetails(){}
	
	public UserDetails(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Collection<Vehicule> getVehicule() {
		return vehicule;
	}

	public void setVehicule(Collection<Vehicule> vehicule) {
		this.vehicule = vehicule;
	}

	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	

}
