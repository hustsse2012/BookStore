package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bookstore.bean.OrderDetailInfo;
import com.bookstore.dao.OrderDetailDao;

public class OrderDetailServlet extends HttpServlet {
	private OrderDetailDao orderDetailDao;
	private String result = "result";
	private String empty = "empty";
	private String OID = "OID";
	private String UID = "UID";

	/**
	 * Constructor of the object.
	 */
	public OrderDetailServlet() {
		super();
	}

	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String oID =  request.getParameter(OID);
		String uID =  request.getParameter(UID);
		
		List<OrderDetailInfo> orderDetailList = new ArrayList<OrderDetailInfo>();
		orderDetailList.addAll(orderDetailDao.orderDetails(oID, uID));
		JSONArray jsonArray = new JSONArray();
		JSONObject resultJsonObject = new JSONObject();
		
		if(orderDetailList.isEmpty()){
			resultJsonObject.put(result, empty);
		}else{
			for(OrderDetailInfo orderdetailinfo : orderDetailList){
				JSONObject obj = new JSONObject();
				
				obj.put("OID",orderdetailinfo.getOID());
				obj.put("UID",orderdetailinfo.getUID());
				obj.put("name",orderdetailinfo.getName());
				obj.put("phone",orderdetailinfo.getPhone());
				obj.put("state",orderdetailinfo.getState());
				obj.put("bookName",orderdetailinfo.getBookName());
				obj.put("bookID",orderdetailinfo.getBookID());
				obj.put("order_time",orderdetailinfo.getOrder_time().toString());
				obj.put("del_address",orderdetailinfo.getDel_address());
				obj.put("level",orderdetailinfo.getLevel());
				obj.put("money_should_pay",orderdetailinfo.getMoney_should_pay());
				obj.put("quantity",orderdetailinfo.getQuantity());
				
				jsonArray.add(obj);
			}
			
			resultJsonObject.put(result, jsonArray);
		}
		
//		JSONObject resultJsonObject = new JSONObject();
//		int flag = orderDetailDao.orderDetails(oID, uID);
//		resultJsonObject.put(result, flag);
		
		out.print(resultJsonObject.toString());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		orderDetailDao = new OrderDetailDao();
	}

}
