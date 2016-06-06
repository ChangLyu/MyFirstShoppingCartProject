package model;

public class ShoppingCart {
	private int userid;
	private int itemId;
	private int itemNumber;
	private int shoppingcartid;
	private String itemName;
	private String itemPictureLink;
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	private float itemPrice;
	public String getItemPictureLink() {
		return itemPictureLink;
	}
	public void setItemPictureLink(String itemPictureLink) {
		this.itemPictureLink = itemPictureLink;
	}
	public float getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(float itemPrice) {
		this.itemPrice = itemPrice;
	}
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
