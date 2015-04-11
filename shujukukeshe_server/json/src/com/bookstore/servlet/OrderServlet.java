package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSON;
import net.sf.json.JSONObject;

import com.bookstore.dao.OrderDao;

public class OrderServlet extends HttpServlet {

	private OrderDao orderDao;

	/**
	 * Initialization of the servlet. <br>
	 * 
	 * @throws ServletException
	 *             if an error occurs
	 */
	public void init() throws ServletException {
		orderDao = new OrderDao();
	}

	/**
	 * Constructor of the object.
	 */
	public OrderServlet() {
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
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doPost(request, response);
	}

	/**
	 * The doPost method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to
	 * post.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		String OID = request.getParameter("OID");
		String orderTime = request.getParameter("order_time");
		String delAddress = request.getParameter("del_address");
		String state = request.getParameter("state");
		String money = request.getParameter("money");
		String userID = request.getParameter("userID");
		String orderItemCount = request.getParameter("order_item_count");
		List<Object> params = new ArrayList<Object>();
		params.add(OID);
		params.add(orderTime);
		params.add(delAddress);
		params.add(state);
		params.add(money);
		params.add(userID);
		params.add(orderItemCount);
		boolean flag = orderDao.insert(params);
		JSONObject js = new JSONObject();
		js.put("flag", flag);
		out.print(js.toString());
		out.flush();
		out.close();
	}

}
