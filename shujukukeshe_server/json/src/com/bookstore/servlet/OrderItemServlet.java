package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.bookstore.dao.OrderItemDao;

public class OrderItemServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private OrderItemDao orderItemDao = null;

	public void init() throws ServletException {
		orderItemDao = new OrderItemDao();
	}

	/**
	 * Constructor of the object.
	 */
	public OrderItemServlet() {
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
		String bookName = request.getParameter("bookName");
		String quantity = request.getParameter("quantity");
		String orderID = request.getParameter("orderID");
		String bookID = request.getParameter("TBID");
		ArrayList<Object> params = new ArrayList<Object>();
		
		params.add(quantity);
		params.add(orderID);
		params.add(bookID);
		params.add(bookName);
		
		
		boolean flag = orderItemDao.insert(params);
		JSONObject js = new JSONObject();
		js.put("flag", flag);
		out.print(js.toString());
		out.flush();
		out.close();
	}

}
