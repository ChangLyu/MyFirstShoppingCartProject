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
	 List<ShoppingCart> list=new ArrayList<ShoppingCart>();
	public List<ShoppingCart> showcart(int userid){

		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println(userid);
		 list= session.createQuery("from ShoppingCart where userid= :id").setParameter("id",userid).list();
 	     session.getTransaction().commit();
 	     session.close(); 
 	     return list; 
	}
	
	public void addtocart(int userid, int item_id, int numberofitems,String name, float price, String picturelink){
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println("shoppingcart addtocart itemid is "+item_id);
		 System.out.println("numberofitems is "+numberofitems);
	     System.out.println("userid is"+userid);

		 list= session.createQuery("from ShoppingCart where itemId= :itemid and userid= :userid").setParameter("itemid",item_id).setParameter("userid",userid).list();
		if(list.isEmpty()){
			 shoppingCart.setUserid(userid);
			 shoppingCart.setItemId(item_id);
			 shoppingCart.setItemNumber(numberofitems);
			 shoppingCart.setItemName(name);
			 shoppingCart.setItemPrice(price);
			 shoppingCart.setItemPictureLink(picturelink);
			 session.save(shoppingCart);
			
		}else{
			 int q=list.get(0).getItemNumber();
			 String hqlUpdate = "update ShoppingCart s set s.itemNumber = :number where itemId= :itemid and userid= :userid";
			 session.createQuery( hqlUpdate ).setParameter("number", q+numberofitems).setParameter("itemid",item_id).setParameter("userid",userid).executeUpdate();
			
		}
	     session.getTransaction().commit();
	     session.close(); 
	}
	
	public int deletefromcart(int userid, int item_id){

		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println("shoppingcart delete itemid is "+item_id);
	     System.out.println("userid is"+userid);
	      list= session.createQuery("from ShoppingCart where itemId= :itemid and userid= :userid").setParameter("itemid",item_id).setParameter("userid",userid).list();
		 int  itemnumber=list.get(0).getItemNumber();
		 session.createQuery("delete from ShoppingCart where itemId= :itemid and userid= :userid").setParameter("itemid",item_id).setParameter("userid",userid).executeUpdate();
	     session.getTransaction().commit();
	     session.close(); 
	     return itemnumber;
	}


}
