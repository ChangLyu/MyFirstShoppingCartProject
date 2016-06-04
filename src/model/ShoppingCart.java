package model;

public class ShoppingCart {
	private int userid;
	private int itemId;
	private int itemNumber;
	private int shoppingcartid;
	public int getShoppingcartid() {
		return shoppingcartid;
	}
	public void setShoppingcartid(int shoppingcartid) {
		this.shoppingcartid = shoppingcartid;
	}
	public int getItemNumber() {
		return itemNumber;
	}
	public void setItemNumber(int itemNumber) {
		this.itemNumber = itemNumber;
	}


	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}

}
