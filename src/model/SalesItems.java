package model;

import java.awt.event.ItemEvent;

public class SalesItems {
	private int itemId;
	private String itemName;
	private String itemDescription;
	private int itemQuantity;
	private String itemPictureLink;
	private float itemPrice;

	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public String getItemDescription() {
		return itemDescription;
	}
	public void setItemDescription(String itemDescription) {
		this.itemDescription = itemDescription;
	}
	public int getItemQuantity() {
		return itemQuantity;
	}
	public void setItemQuantity(int itemQuantity) {
		this.itemQuantity = itemQuantity;
	}
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
	

}
