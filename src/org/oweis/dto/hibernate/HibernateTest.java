package org.oweis.dto.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.oweis.dto.Address;
import org.oweis.dto.UserDetails;
import org.oweis.dto.Vehicule;

public class HibernateTest {
	
	public static void main(String[] args){
		
		UserDetails	user1 = new UserDetails("Oweis");
		
		Vehicule vehicule1 = new Vehicule("Dacia");
		Vehicule vehicule2 = new Vehicule("Ford");
		
		user1.setJoinIds(vehicule1);
		user1.setJoinIds(vehicule2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		session.persist(user1);
		session.getTransaction().commit();
		session.close();
	
	}

}
