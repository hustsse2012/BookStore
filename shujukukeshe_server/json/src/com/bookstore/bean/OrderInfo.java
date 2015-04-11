package com.bookstore.bean;

import java.sql.Date;




public class OrderInfo {
	private String orderID;
	private String orderTime;
	private String address;
	private String state;
	private float money;
	private String userID;
	private int itemCounts;
	

	public OrderInfo(String orderID, String orderTime, String address,
			String state, float money, String userID, int itemCounts) {
		this.orderID = orderID;
		this.orderTime = orderTime;
		this.address = address;
		this.state = state;
		this.money = money;
		this.userID = userID;
		this.itemCounts = itemCounts;
	}
	public String getOrderID() {
		return orderID;
	}
	public void setOrderID(String orderID) {
		this.orderID = orderID;
	}
	public String getOrderTime() {
		return orderTime;
	}
	public void setOrderTime(String orderTime) {
		this.orderTime = orderTime;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public float getMoney() {
		return money;
	}
	public void setMoney(float money) {
		this.money = money;
	}
	public int getItemCounts() {
		return itemCounts;
	}
	public void setItemCounts(int itemCounts) {
		this.itemCounts = itemCounts;
	}
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	
}
