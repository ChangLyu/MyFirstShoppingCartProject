package dao;

import java.util.Map;

import org.hibernate.Query;
import org.hibernate.Session;

import hibernateutils.HibernateUtils;
import model.Manager;

public class ManagerDao {
	Session session;
	
	public String login( Manager manager,Map<String, Object> sessionMap){
		if(manager.getManagername().isEmpty()||manager.getManagerpassword().isEmpty()){
			System.out.println("input null value");
			return "INPUTNULLVALUE";
		}else{
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 Query query= session.createQuery("select managerpassword from Manager where managername= ? ");
	     query.setParameter(0,manager.getManagername());	     
	     if(query.list().isEmpty()){	       	  
	   	      session.getTransaction().commit();
	   	      session.close(); 
	   	      System.out.println("notexist");
	    	  return "NOTEXIST";
	      }else  if((query.list().get(0)).equals(manager.getManagerpassword())){
	    	  
	 		 Query query2= session.createQuery("select managerid from Manager where managername= ? ");
		     query2.setParameter(0,manager.getManagername());
		      int id=(Integer)query2.list().get(0);
			    //if successfully login, put the customer into the session map. Then in the jsp, we can still see the status of customer.
		      sessionMap.put("managerid",id);
		      sessionMap.put("managername",manager.getManagername());
	   	      session.getTransaction().commit();
	   	      session.close();
	    	  return "SUCCESSLOGIN";
	      }	else{
	   	      session.getTransaction().commit();
	   	      session.close();
	   	      System.out.println("faillogin");
	    	  return "FAILLOGIN";
	      }
	}	
	}

}
