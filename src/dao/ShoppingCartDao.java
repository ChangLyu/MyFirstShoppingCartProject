package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.Session;

import hibernateutils.HibernateUtils;
import model.SalesItems;
import model.ShoppingCart;

public class ShoppingCartDao {
	ShoppingCart shoppingCart=new ShoppingCart();
	Session session;
	public void addUser(ShoppingCart shoppingcart){
		 System.out.println(shoppingcart.getUserid()+"shoppingcart id,from dao");
			session = HibernateUtils.getSessionFactory().openSession();
			session.beginTransaction();
		    session.save(shoppingcart);
			session.getTransaction().commit();
			session.close(); 
	}
	public List<ShoppingCart> showcart(int userid){
		 List<ShoppingCart> list=new ArrayList<ShoppingCart>();
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println(userid);
		 list= session.createQuery("from ShoppingCart where userid= :id").setParameter("id",userid).list();
 	     session.getTransaction().commit();
 	     session.close(); 
 	     return list; 
	}
	
	public void addtocart(int userid, int item_id, int numberofitems){
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println("shoppingcart addtocart itemid is "+item_id);
		 System.out.println("numberofitems is "+numberofitems);
	     System.out.println("userid is"+userid);
		 List<ShoppingCart> list=new ArrayList<ShoppingCart>();
		 list= session.createQuery("from ShoppingCart where itemId= :itemid and userid= :userid").setParameter("itemid",item_id).setParameter("userid",userid).list();
		if(list.isEmpty()){
			 shoppingCart.setUserid(userid);
			 shoppingCart.setItemId(item_id);
			 shoppingCart.setItemNumber(numberofitems);
			 session.save(shoppingCart);
			
		}else{
			 int q=list.get(0).getItemNumber();
			 String hqlUpdate = "update ShoppingCart s set s.itemNumber = :number where itemId= :itemid and userid= :userid";
			 session.createQuery( hqlUpdate ).setParameter("number", q+numberofitems).setParameter("itemid",item_id).setParameter("userid",userid).executeUpdate();
			
		}
	     session.getTransaction().commit();
	     session.close(); 
	}


}
