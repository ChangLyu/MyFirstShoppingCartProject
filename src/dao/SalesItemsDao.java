package dao;

import java.util.List;

import org.hibernate.Session;

import hibernateutils.HibernateUtils;
import model.SalesItems;

public class SalesItemsDao {
	Session session;

	
	public List<SalesItems> listall(List<SalesItems> list){
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 list= session.createQuery("from SalesItems").list();
  	     session.getTransaction().commit();
  	     session.close(); 
  	     return list;
	}

}
