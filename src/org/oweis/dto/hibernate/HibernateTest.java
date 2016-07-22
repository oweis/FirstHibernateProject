package org.oweis.dto.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.oweis.dto.Address;
import org.oweis.dto.UserDetails;
import org.oweis.dto.Vehicule;

public class HibernateTest {
	
	public static void main(String[] args){
		
		UserDetails	user = new UserDetails();
		
		Vehicule vehicule = new Vehicule();

		vehicule.setVehiculeName("Car");
		user.setVehicule(vehicule);
		
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
			
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		session.save(user);
		session.save(vehicule);
		session.getTransaction().commit();
		session.close();
	
	}

}
