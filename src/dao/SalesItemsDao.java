package dao;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.NamedAttributeNode;

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

	public List<SalesItems> showdetail(int item_id){
		 List<SalesItems> list=new ArrayList<SalesItems>();
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 System.out.println(item_id);
		 list= session.createQuery("from SalesItems where itemId= :id").setParameter("id",item_id).list();
 	     session.getTransaction().commit();
 	     session.close(); 
 	     return list;
	}
	public void edit(SalesItems salesItems){
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 session.update(salesItems);
	     session.getTransaction().commit();
	     session.close(); 
	}
	//not done
	public void add(SalesItems salesItems){
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 session.save(salesItems);
	     session.getTransaction().commit();
	     session.close(); 
	}
	public void delete(int id){
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 SalesItems s=(SalesItems)session.get(SalesItems.class,id);
		 session.delete(s);
	     session.getTransaction().commit();
	     session.close(); 
	}
	
	public void decreasequantity(int item_id, int numberofitems){
		 System.out.println("itemid is"+item_id);
		 System.out.println("numberofitems is"+numberofitems);
		 
		 List<SalesItems> list=new ArrayList<SalesItems>();
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 list= session.createQuery("from SalesItems where itemId= :id").setParameter("id",item_id).list();
		 int q=list.get(0).getItemQuantity();
		  q=q-numberofitems;
		 System.out.println("the left quantity of item is:"+q);
		 String hqlUpdate = "update SalesItems s set s.itemQuantity = :quantity where s.itemId = :id";
		 session.createQuery( hqlUpdate ).setParameter("quantity", q).setParameter("id", item_id ).executeUpdate();
	     session.getTransaction().commit();
	     session.close(); 
	}
	public boolean checkquantity(int item_id, int numberofitems){		 
		 List<SalesItems> list=new ArrayList<SalesItems>();
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 list= session.createQuery("from SalesItems where itemId= :id").setParameter("id",item_id).list();
		 int q=list.get(0).getItemQuantity();
          if(q>=numberofitems){
    		  session.getTransaction().commit();
    		  session.close(); 
        	  return true;
          }else{
    		  session.getTransaction().commit();
    		  session.close();
    		  return false;
          }

	}
	//when u remove something from your shopping list, u have to restore them in the items list.
	public void restoreitem(int item_id, int numberofitems){
		 System.out.println("itemid is"+item_id);
		 System.out.println("numberofitems is"+numberofitems);
		 
		 List<SalesItems> list=new ArrayList<SalesItems>();
		 session = HibernateUtils.getSessionFactory().openSession();
		 session.beginTransaction();
		 list= session.createQuery("from SalesItems where itemId= :id").setParameter("id",item_id).list();
		 int q=list.get(0).getItemQuantity();
		  q=q+numberofitems;

		 String hqlUpdate = "update SalesItems s set s.itemQuantity = :quantity where s.itemId = :id";
		 session.createQuery( hqlUpdate ).setParameter("quantity", q).setParameter("id", item_id ).executeUpdate();
	     session.getTransaction().commit();
	     session.close(); 
	}

}
