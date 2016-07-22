package org.oweis.dto.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.oweis.dto.Address;
import org.oweis.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args){
		
		UserDetails	user = new UserDetails();
		UserDetails user2 = new UserDetails();
		
		Address addr = new Address();
		addr.setStreet("street");
		addr.setCity("city");
		addr.setPincode("0123");
		addr.setState("state");
		
		Address addr2 = new Address();
		addr2.setStreet("street 2");
		addr2.setCity("city 2");
		addr2.setPincode("0123 2");
		addr2.setState("state 2");
		
		user.setUserName("Oweis");
		user.getListOfAddresses().add(addr);
		user.getListOfAddresses().add(addr2);
		
		user2.setUserName("Yahya");
		user2.getListOfAddresses().add(addr);
		user2.getListOfAddresses().add(addr2);
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		Session session2 = sessionFactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
		session.close();
		
		session2.beginTransaction();
		session2.save(user2);
		session2.getTransaction().commit();
		session2.close();
		
	//	user = null;
	//  session = sessionFactory.openSession();
		//user = (UserDetails) session.get(UserDetails.class,0);
		//System.out.println(user.getListOfAddresses().size());
		
	}

}
