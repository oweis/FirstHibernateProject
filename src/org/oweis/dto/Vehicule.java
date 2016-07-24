package org.oweis.dto;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="VHICULE_TYPE",discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Vehicule")
public class Vehicule {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int vehiculeId;
	private String vehiculeName;
	@ManyToOne
	@NotFound(action=NotFoundAction.IGNORE)
	private UserDetails user;
	
	
	public Vehicule(){}
			
	public Vehicule(String vehiculeName){
		this.vehiculeName = vehiculeName;
	}
	
	public Vehicule(int vehiculeId, String vehiculeName) {
		super();
		this.vehiculeId = vehiculeId;
		this.vehiculeName = vehiculeName;
	}

	public UserDetails getUser() {
		return user;
	}

	public void setUser(UserDetails user) {
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
