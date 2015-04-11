package com.bookstore.bean;

public class UserAccount {
	private String UID;
	private String userName;
	private String password;
	private String address;
	private String email;
	private String phone;
	private int level;
	private float accountBalance;
	private float moneyHasConsume;
	private float userAccountMoney;
	
	public UserAccount(){}
	public UserAccount(String uID, String userName, String password,
			String address, String email, String phone, int level,
			float accountBalance, float moneyHasConsume, float userAccountMoney) {
		super();
		UID = uID;
		this.userName = userName;
		this.password = password;
		this.address = address;
		this.email = email;
		this.phone = phone;
		this.level = level;
		this.accountBalance = accountBalance;
		this.moneyHasConsume = moneyHasConsume;
		this.userAccountMoney = userAccountMoney;
	}
	public String getUID() {
		return UID;
	}
	public void setUID(String uID) {
		UID = uID;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public int getLevel() {
		return level;
	}
	public void setLevel(int level) {
		this.level = level;
	}
	public float getAccountBalance() {
		return accountBalance;
	}
	public void setAccountBalance(float accountBalance) {
		this.accountBalance = accountBalance;
	}
	public float getMoneyHasConsume() {
		return moneyHasConsume;
	}
	public void setMoneyHasConsume(float moneyHasConsume) {
		this.moneyHasConsume = moneyHasConsume;
	}
	public float getUserAccountMoney() {
		return userAccountMoney;
	}
	public void setUserAccountMoney(float userAccountMoney) {
		this.userAccountMoney = userAccountMoney;
	}
}
