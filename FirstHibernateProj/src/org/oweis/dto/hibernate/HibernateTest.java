package org.oweis.dto.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.oweis.dto.Address;
import org.oweis.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args){
		
		UserDetails	user = new UserDetails();
		
		Address addr = new Address();
		addr.setStreet("street");
		addr.setCity("city");
		addr.setPincode("0123");
		addr.setState("state");
		
		user.setUserName("Oweis");
		user.setAddress(addr);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}

}
