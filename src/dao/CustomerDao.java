package dao;


import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;
import org.hibernate.Query;
import org.hibernate.Session;

import action.ShoppingCartAction;
import hibernateutils.HibernateUtils;
import model.Customer;

public class CustomerDao {
	

       Session session;
       // just need to add user to the shopping cart when he is registering. Maybe using the spring, it will be better
  	    ShoppingCartAction shoppingCartAction=new ShoppingCartAction(); 
	public String register(Customer customer){
		
		if(customer.getUsername().isEmpty()||customer.getPassword().isEmpty()){
			return "INPUTNULLVALUE";
		}else{
		
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
		 
			Query query= session.createQuery("select password from Customer where username= ? ");
			query.setParameter(0,customer.getUsername());	     
			if(query.list().isEmpty()){
				session.save(customer);
				session.getTransaction().commit();
				session.close(); 


				return "SUCCESSREGISTER";
			}else{
	       	  
				session.getTransaction().commit();
				session.close();
				return "FAILREGISTER";
			}	
		}
	}
	
	public String login(Customer customer,Map<String, Object> sessionMap){	
		if(customer.getUsername().isEmpty()||customer.getPassword().isEmpty()){
			System.out.println("input null value");
			return "INPUTNULLVALUE";
		}else{
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println(customer.getUsername()+customer.getPassword());
		 Query query= session.createQuery("select password from Customer where username= ? ");
	     query.setParameter(0,customer.getUsername());	     
	     if(query.list().isEmpty()){	       	  
	   	      session.getTransaction().commit();
	   	      session.close(); 
	   	      System.out.println("notexist");
	    	  return "NOTEXIST";
	      }else  if((query.list().get(0)).equals(customer.getPassword())){
	    	  
	 		 Query query2= session.createQuery("select userid from Customer where username= ? ");
		     query2.setParameter(0,customer.getUsername());
		      int id=(Integer)query2.list().get(0);
			    //if successfully login, put the customer into the session map. Then in the jsp, we can still see the status of customer.
		      System.out.println("login successfully, user name is:"+customer.getUsername());
		      System.out.println("user id is:"+id);
		      sessionMap.put("userid",id);
		      sessionMap.put("username",customer.getUsername());
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
