package org.oweis.dto.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.oweis.dto.FourWheeler;
import org.oweis.dto.TwoWheeler;
import org.oweis.dto.Vehicule;

public class HibernateTest {
	
	public static void main(String[] args){
		
		
		Vehicule vehicule1 = new Vehicule("Dacia");
		
		TwoWheeler bike = new TwoWheeler("Bike");
		bike.setSteeringHandle("Bike Steering Handle");
		
		FourWheeler car = new FourWheeler("Car");
		car.setSteeringWheel("Car Steering Wheel");
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		session.save(vehicule1);
		session.save(bike);
		session.save(car);
		session.close();
	
	}

}
