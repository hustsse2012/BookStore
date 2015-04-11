package com.bookstore.bean;

public class CartInfo {
	int quantity;
	String userID;
	String bookID;
	String bookName;
	int TBID;
	float price;
	float discount;
	
	
	
	public int getTBID() {
		return TBID;
	}
	public void setTBID(int tBID) {
		TBID = tBID;
	}
	public CartInfo(int quantity, String userID, String bookID,
			String bookName, float price, float discount,int TBID) {
		super();
		this.quantity = quantity;
		this.userID = userID;
		this.bookID = bookID;
		this.bookName = bookName;
		this.price = price;
		this.discount = discount;
		this.TBID = TBID;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public float getDiscount() {
		return discount;
	}
	public void setDiscount(float discount) {
		this.discount = discount;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public String getBookID() {
		return bookID;
	}
	public void setBookID(String bookID) {
		this.bookID = bookID;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	
}
