package org.oweis.dto.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Restrictions;
import org.oweis.dto.UserDetails;

public class HibernateTest {
	
	public static void main(String[] args){
		
		// if we want to simplify things
		UserDetails exampleUser = new UserDetails();
		exampleUser.setUserName("User 6");
		
		Example example = Example.create(exampleUser);
		
		//	Dispo if we need it
		// 		Example example = Example.create(exampleUser).excludeProperty("userName").enableLike();
		
		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		
		/* if we want return specific columns : id for example		  		Criteria criteria = session.createCriteria(UserDetails.class)
								.setProjection(Projections.property("userId"));
		 */
		Criteria criteria = session.createCriteria(UserDetails.class).add(example);
		
		/* &&
		 *  criteria.add(Restrictions.eq("userName","User 9")).add(Restrictions.gt("userId",5));
		 */
		// ||
		 criteria.add(Restrictions.or(Restrictions.eq("userName","User 1"),Restrictions.gt("userId",5)));

		List<UserDetails> users = (List<UserDetails>) criteria.list();
		
		session.getTransaction().commit();
		session.close();

		for(UserDetails u : users) System.out.println(u.getUserName());
		

	}

}
