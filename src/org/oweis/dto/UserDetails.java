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
	@ElementCollection
	@JoinTable(name="User_Address",
		joinColumns = @JoinColumn(name="User_Id"))
	@GenericGenerator(name = "hilo-gen", strategy = "hilo")
	@CollectionId(columns = { @Column(name="Address_id") }, generator = "hilo-gen", type = @Type(type = "long"))
	private Collection<Address> listOfAddresses = new ArrayList<Address>();
	@OneToOne
	@JoinColumn(name="VEHICULE_ID")
	private Vehicule vehicule;
	
	public UserDetails(){}
	
	public UserDetails(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	public Vehicule getVehicule() {
		return vehicule;
	}

	public void setVehicule(Vehicule vehicule) {
		this.vehicule = vehicule;
	}

	public Collection<Address> getListOfAddresses() {
		return listOfAddresses;
	}

	public void setListOfAddresses(Collection<Address> listOfAddresses) {
		this.listOfAddresses = listOfAddresses;
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
