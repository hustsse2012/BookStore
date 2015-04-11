package com.bookstore.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

import com.bookstore.dao.AccountUpdateDao;

public class UpdateAccountServlet extends HttpServlet {
	private AccountUpdateDao accountUpdateDao;
	private String result = "result";
	
	String UID = null;
	String password = null;
	String address= null;
	String email= null;
	String phone= null;
	String name= null;

	/**
	 * Constructor of the object.
	 */
	public UpdateAccountServlet() {
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

//		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
		
		UID = request.getParameter("UID");
		password = request.getParameter("password");
		address = request.getParameter("address");
		email = request.getParameter("email");
		phone = request.getParameter("phone");
		name = request.getParameter("name");
//		
//		String value = accountUpdateDao.updateAccount(UID);
//		JSONObject jsonObject = new JSONObject();
//		jsonObject.put(result, value);
		
		List<Object> params = new ArrayList<Object>();
		
		params.add(name);
		params.add(password);
		params.add(address);
		params.add(email);
		params.add(phone);
		params.add(UID);
		
		int value = accountUpdateDao.updateAccount(UID, params);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put(result, value);
		
		out.print(jsonObject.toString());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		accountUpdateDao = new AccountUpdateDao();
	}

}
