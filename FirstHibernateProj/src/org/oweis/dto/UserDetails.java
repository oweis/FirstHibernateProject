package org.oweis.dto;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name="USER_DETAILS")
public class UserDetails {
	
	@Id
	private int userId;
	@Column (name="USER_NAME")
	private String userName;
	@Embedded
	private Address address;
	
	public UserDetails(){}
	
	public UserDetails(int userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}
	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
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
