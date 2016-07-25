package org.oweis.dto.hibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateTest {
	
	public static void main(String[] args){

		
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
	
		session.beginTransaction();
		
	/* CREATE 10 User
 		for(int i=0;i<10;i++){
			UserDetails user = new UserDetails();
			user.setUserName("User " + i);
			session.save(user);
		}
		//if we modify the name at this level, hibernate will update the bd
		 user.setUserName("Updated Persistant");
	*/
	
	/* READ :
		 	UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
	 		S.O.P.(user.getName());
	*/
	
	/* UPDATE : 
	 		UserDetails user = (UserDetails) session.get(UserDetails.class, 5);
	 		user.setUserName("Updated");
	 		session.update(user);
	*/
		
	/* Delete User where id=6
			UserDetails user = (UserDetails) session.get(UserDetails.class, 6);
			session.delete(user);
 	*/
	
		session.getTransaction().commit();
		session.close();
		
	/*  We can access the user even after closing the session 
	 * 		System.out.println("UserName (where id=6) : " + user.getUserName());
	 */
	
	}

}
