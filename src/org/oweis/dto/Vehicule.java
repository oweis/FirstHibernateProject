package org.oweis.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Vehicule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehiculeId;
	private String vehiculeName;
	@ManyToMany(mappedBy="vehicule")
	private Collection<UserDetails> user = new ArrayList<UserDetails>();
	
	public Vehicule(){}
			
	public Vehicule(String vehiculeName){
		this.vehiculeName = vehiculeName;
	}
	
	public Vehicule(int vehiculeId, String vehiculeName) {
		super();
		this.vehiculeId = vehiculeId;
		this.vehiculeName = vehiculeName;
	}

	public Collection<UserDetails> getUser() {
		return user;
	}

	public void setUser(Collection<UserDetails> user) {
		this.user = user;
	}

	public int getVehiculeId() {
		return vehiculeId;
	}
	public void setVehiculeId(int vehiculeId) {
		this.vehiculeId = vehiculeId;
	}
	public String getVehiculeName() {
		return vehiculeName;
	}
	public void setVehiculeName(String vehiculeName) {
		this.vehiculeName = vehiculeName;
	}

}
