package com.bookstore.bean;

import java.sql.Date;

public class OrderDetailInfo {
	private String OID;
	private String order_time;
	private String del_address;
	private String state;
	private String userName;
	private String phone;
	private int level;
	private String BID;
	private String bookName;
	private float money_should_pay;
	private String userID;
	private int quantity;
	
	
	
	public String getUserName() {
		return userName;
	}



	public void setUserName(String userName) {
		this.userName = userName;
	}



	public String getBID() {
		return BID;
	}



	public void setBID(String bID) {
		BID = bID;
	}



	public String getUserID() {
		return userID;
	}



	public void setUserID(String userID) {
		this.userID = userID;
	}



	public int getQuantity() {
		return quantity;
	}



	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}



	public OrderDetailInfo(String oID, String order_time, String del_address,
			String state, String userName, String phone, int level,String userID, int quantity ,String bID,
			String bookName,float money_should_pay) {
		super();
		OID = oID;
		this.order_time = order_time;
		this.del_address = del_address;
		this.state = state;
		this.userName = userName;
		this.phone = phone;
		this.level = level;
		BID = bID;
		this.bookName = bookName;
		this.money_should_pay = money_should_pay;
		this.userID = userID;
		this.quantity = quantity;
	}



	public String getOID() {
		return OID;
	}



	public void setOID(String oID) {
		OID = oID;
	}



	public String getUID() {
		return userID;
	}



	public void setUID(String uID) {
		userID = uID;
	}



	public String getName() {
		return userName;
	}



	public void setName(String name) {
		this.userName = name;
	}



	public String getPhone() {
		return phone;
	}



	public void setPhone(String phone) {
		this.phone = phone;
	}



	public String getState() {
		return state;
	}



	public void setState(String state) {
		this.state = state;
	}



	public String getBookName() {
		return bookName;
	}



	public void setBookName(String bookName) {
		this.bookName = bookName;
	}



	public String getBookID() {
		return BID;
	}



	public void setBookID(String bookID) {
		this.BID = bookID;
	}



	public String getOrder_time() {
		return order_time;
	}



	public void setOrder_time(String order_time) {
		this.order_time = order_time;
	}



	public String getDel_address() {
		return del_address;
	}



	public void setDel_address(String del_address) {
		this.del_address = del_address;
	}



	public int getLevel() {
		return level;
	}



	public void setLevel(int level) {
		this.level = level;
	}



	public float getMoney_should_pay() {
		return money_should_pay;
	}



	public void setMoney_should_pay(float money_should_pay) {
		this.money_should_pay = money_should_pay;
	}




	
	
}
