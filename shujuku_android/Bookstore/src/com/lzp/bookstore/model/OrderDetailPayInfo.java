package com.lzp.bookstore.model;

public class OrderDetailPayInfo {
	private String tBID;
	private String bkName;
	private String bkNum;
	
	public OrderDetailPayInfo(String tBID, String bkName, String bkNum) {
		super();
		this.tBID = tBID;
		this.bkName = bkName;
		this.bkNum = bkNum;
	}
	
	public String gettBID() {
		return tBID;
	}
	public void settBID(String tBID) {
		this.tBID = tBID;
	}
	public String getBkName() {
		return bkName;
	}
	public void setBkName(String bkName) {
		this.bkName = bkName;
	}
	public String getBkNum() {
		return bkNum;
	}
	public void setBkNum(String bkNum) {
		this.bkNum = bkNum;
	}
	
	
}
