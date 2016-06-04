package action;

import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.ShoppingCartDao;
import model.Customer;
import model.ShoppingCart;

public class ShoppingCartAction extends ActionSupport implements ModelDriven, SessionAware{
	ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
	private Map<String, Object> sessionMap;
	ShoppingCart shoppingCart=new ShoppingCart();
	int numberofitems;
	int itemId;
	
	public void addUser(Customer customer){
		ShoppingCart shoppingcart=new ShoppingCart();
		shoppingcart.setUserid(customer.getUserid());
		System.out.println(customer.getUserid()+"method of add user in action");
		shoppingCartDao.addUser(shoppingcart);
	}
	
	public String addtocart(){
		 System.out.println("shoppingcart addtocart itemid is "+itemId);
		 System.out.println("numberofitems is "+numberofitems);
	     int userid=(Integer)sessionMap.get("userid");
	     System.out.println("userid is"+userid);
		 shoppingCartDao.addtocart(userid,itemId,numberofitems);
		 System.out.println("should return");
		 return "SUCCESSADD";
	}
	
	public void showcart(){
        int id=(Integer)sessionMap.get("userid");
		shoppingCartDao.showcart(id);
	}
	
	public int getNumberofitems() {
		return numberofitems;
	}

	public void setNumberofitems(int numberofitems) {
		this.numberofitems = numberofitems;
	}

	public int getItemId() {
		return itemId;
	}

	public void setItemId(int itemId) {
		this.itemId = itemId;
	}


	
	@Override
	public void setSession(Map<String, Object> sessionMap) {
		this.sessionMap = sessionMap;
		
	}

	@Override
	public Object getModel() {
		// TODO Auto-generated method stub
		return null;
	}

}
