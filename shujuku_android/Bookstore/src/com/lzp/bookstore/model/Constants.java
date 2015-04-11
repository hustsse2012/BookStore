package com.lzp.bookstore.model;

public class Constants {
	public static String address;
	public static String userID = "";

	// 老师测试时，请修改此base_url 为本机ip地址
	
	public static final String BASE_URL = "http://feifeiiong.eicp.net";
	public static final String LOGIN_URI = BASE_URL+"/json/LoginServlet";
	public static final String REGIST_URI = BASE_URL+"/json/RegistServlet";
	public static final String GET_CART_URL = BASE_URL+"/json/GetCartServlet";
	public static final String POST_TO_CART_URI = BASE_URL+"/json/CartServlet";
	public static final String GET_BOOKS_URI = BASE_URL+"/json/BooksServlet";
	public static final String OEDER_DETAIL_PAY_URI = BASE_URL+"/json/HasPayOrderServlet";
	public static final String GET_ORDER = BASE_URL+"/json/GetOrderServlet";
	public static final String ORDER_DETAIL_URI = BASE_URL+"/json/OrderDetailServlet";
	public static final String ORDER_ITEM_GENERATE_SERVLET_URL = BASE_URL+"/json/OrderItemServlet";
	public static final String ORDER_GENERATE_SERVLET_URL = BASE_URL+"/json/OrderServlet";
	public static final String SearchServlet = BASE_URL+"/json/SearchServlet";
	public static final String GET_ACCOUNT_SERVLET_URL = BASE_URL+"/json/GetUserAccount";
	public static final String UPDATE_ACCOUNT_SERVLET_URL = BASE_URL+"/json/UpdateAccountServlet";
	public static float user_account_money = 0;
}
