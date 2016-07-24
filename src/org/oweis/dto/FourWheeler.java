package org.oweis.dto;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
public class FourWheeler extends Vehicule {
	
	private String SteeringWheel;

	public FourWheeler() {
		// TODO Auto-generated constructor stub
	}

	public FourWheeler(String vehiculeName) {
		super(vehiculeName);
		// TODO Auto-generated constructor stub
	}

	public FourWheeler(int vehiculeId, String vehiculeName) {
		super(vehiculeId, vehiculeName);
		// TODO Auto-generated constructor stub
	}

	public String getSteeringWheel() {
		return SteeringWheel;
	}

	public void setSteeringWheel(String steeringWheel) {
		SteeringWheel = steeringWheel;
	}

}
