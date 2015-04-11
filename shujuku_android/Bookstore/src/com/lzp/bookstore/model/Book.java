package com.lzp.bookstore.model;

public class Book {
	private String TBID;
	private String BID;
	private String name;
	private String authors;
	private String publish;
	private float price;
	private String catalogue;
	private int buy_num;
	private int stockNum;//库存量
	private String supplierID;
	
	public String getCatalogue() {
		return catalogue;
	}

	public void setCatalogue(String catalogue) {
		this.catalogue = catalogue;
	}

	public int getBuy_num() {
		return buy_num;
	}

	public void setBuy_num(int buy_num) {
		this.buy_num = buy_num;
	}

	
	public Book(String tBID, String bID, String name, String authors,
			String publish, float price, String catalogue, int buy_num,
			int stockNum, String supplierID) {
		super();
		TBID = tBID;
		BID = bID;
		this.name = name;
		this.authors = authors;
		this.publish = publish;
		this.price = price;
		this.catalogue = catalogue;
		this.buy_num = buy_num;
		this.stockNum = stockNum;
		this.supplierID = supplierID;
	}

	public String getTBID() {
		return TBID;
	}
	public void setTBID(String tBID) {
		TBID = tBID;
	}
	public String getBID() {
		return BID;
	}
	public void setBID(String bID) {
		BID = bID;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthors() {
		return authors;
	}
	public void setAuthors(String authors) {
		this.authors = authors;
	}
	public String getPublish() {
		return publish;
	}
	public void setPublish(String publish) {
		this.publish = publish;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public int getStockNum() {
		return stockNum;
	}
	public void setStockNum(int stockNum) {
		this.stockNum = stockNum;
	}
	public String getSupplierID() {
		return supplierID;
	}
	public void setSupplierID(String supplierID) {
		this.supplierID = supplierID;
	}
	
	
}
