package dao;


import org.hibernate.Query;
import org.hibernate.Session;


import hibernateutils.HibernateUtils;
import model.Customer;

public class CustomerDao {
	
       Session session;

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
	
	public String login(Customer customer){	
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
