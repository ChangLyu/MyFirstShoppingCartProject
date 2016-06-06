package action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

import dao.SalesItemsDao;
import dao.ShoppingCartDao;
import model.Customer;
import model.SalesItems;
import model.ShoppingCart;

public class ShoppingCartAction extends ActionSupport implements ModelDriven, SessionAware{
	ShoppingCartDao shoppingCartDao=new ShoppingCartDao();
	SalesItemsDao salesItemsDao=new SalesItemsDao();
	private Map<String, Object> sessionMap;
	private  String result="";
	 private List<ShoppingCart> list=new ArrayList<ShoppingCart>();
	 private List<SalesItems> list2=new ArrayList<SalesItems>();

	public List<ShoppingCart> getList() {
		return list;
	}

	public void setList(List<ShoppingCart> list) {
		this.list = list;
	}

	ShoppingCart shoppingCart=new ShoppingCart();
	int numberofitems;
	int itemId;
	

	
	public String addtocart(){
		 System.out.println("shoppingcart addtocart itemid is "+itemId);
		 System.out.println("numberofitems is "+numberofitems);
	     int userid=(Integer)sessionMap.get("userid");
	     System.out.println("userid is"+userid);
       // if the quantity you want to put in your cart is above the left number of items in the item list, then u can do the addtocart operation.
	     if(salesItemsDao.checkquantity(itemId,numberofitems)){
	    	 //get some information from salesitems
	    	list2= salesItemsDao.showdetail(itemId);
	    	
			 shoppingCartDao.addtocart(userid,itemId,numberofitems,list2.get(0).getItemName(),list2.get(0).getItemPrice(),list2.get(0).getItemPictureLink());
			 System.out.println("should return");
			 result="SUCCESSADD";
	     }else{
	    	 System.out.println("fail add");
	    	 result="FAILADD";
	     }
	     return result;

	}
	
	public String showcart(){
        int id=(Integer)sessionMap.get("userid");
		list=shoppingCartDao.showcart(id);
		return "SUCCESSSHOWCART";
	}
	public String deletefromcart(){
        int id=(Integer)sessionMap.get("userid");
		int itemnumber=shoppingCartDao.deletefromcart(id,itemId);
		System.out.println("finish deleting from shopping cart, time to restore to the item list");
		salesItemsDao.restoreitem(itemId,itemnumber);
		return "SUCCESSDELETE";
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

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
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
