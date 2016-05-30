package hibernateutils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
private static  SessionFactory sessionFactory=null;

	
	public static SessionFactory getSessionFactory(){
		
	sessionFactory=new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		
		return sessionFactory;
	}

}
