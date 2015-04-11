package com.lzp.bookstore.model;

public class OrderDetailInfo {
	private String OID;
	private String orderTime;
	private String address;
	private String state;
	private float money;
	private String userID;
	private int itemCount;
	
	
	public OrderDetailInfo(String oID, String orderTime, String address,
			String state, float money, String userID, int itemCount) {
		super();
		OID = oID;
		this.orderTime = orderTime;
		this.address = address;
		this.state = state;
		this.money = money;
		this.userID = userID;
		this.itemCount = itemCount;
	}
	public String getOID() {
		return OID;
	}
	public void setOID(String oID) {
		OID = oID;
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
	public String getUserID() {
		return userID;
	}
	public void setUserID(String userID) {
		this.userID = userID;
	}
	public int getItemCount() {
		return itemCount;
	}
	public void setItemCount(int itemCount) {
		this.itemCount = itemCount;
	}
	
	
}
