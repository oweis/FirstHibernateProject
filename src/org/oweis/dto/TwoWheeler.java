package org.oweis.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class TwoWheeler extends Vehicule {
	
	private String SteeringHandle;
	

	public TwoWheeler() {
		// TODO Auto-generated constructor stub
	}

	public TwoWheeler(String vehiculeName) {
		super(vehiculeName);
	}

	public TwoWheeler(int vehiculeId, String vehiculeName) {
		super(vehiculeId, vehiculeName);
	}

	public String getSteeringHandle() {
		return SteeringHandle;
	}

	public void setSteeringHandle(String steeringHandle) {
		SteeringHandle = steeringHandle;
	}

}
