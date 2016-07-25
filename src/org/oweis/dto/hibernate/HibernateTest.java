package org.oweis.dto.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.oweis.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args){

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		
	//	Query query = session.createQuery("from UserDetails where userid>5");
	//	Query query = session.createQuery("select username from UserDetails");
		Query query = session.getNamedQuery("UserDetails.byId");
		query.setFirstResult(0);
		query.setMaxResults(4);
		query.setInteger("userid", 2);
		List<UserDetails> users = (List<UserDetails>) query.list();

		session.getTransaction().commit();
		session.close();
		//System.out.println("Size Of List : " + users.size());
		for(UserDetails u : users) System.out.println(u.getUserName());
		

	}

}
