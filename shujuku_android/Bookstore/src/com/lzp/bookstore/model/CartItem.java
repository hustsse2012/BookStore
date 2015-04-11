package com.lzp.bookstore.model;

public class CartItem {
private String bookName;
private float price;
private float discount;
private int amount;
private String bookID;
private int TBID;

public CartItem(String bookName, float price, float discount, int amount,String bookID,int TBID) {
	this.bookName = bookName;
	this.price = price;
	this.discount = discount;
	this.amount = amount;
	this.setBookID(bookID);
	this.setTBID(TBID);
}
public String getBookName() {
	return bookName;
}
public void setBookName(String bookName) {
	this.bookName = bookName;
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
public int getAmount() {
	return amount;
}
public void setAmount(int amount) {
	this.amount = amount;
}
public String getBookID() {
	return bookID;
}
public void setBookID(String bookID) {
	this.bookID = bookID;
}
public int getTBID() {
	return TBID;
}
public void setTBID(int tBID) {
	TBID = tBID;
}
}
