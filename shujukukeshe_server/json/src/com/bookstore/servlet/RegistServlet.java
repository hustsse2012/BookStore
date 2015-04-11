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

import com.bookstore.dao.RegistDao;

public class RegistServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	private RegistDao registDao;

	/**
	 * Constructor of the object.
	 */
	public RegistServlet() {
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

		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		String uid = request.getParameter("uid");
		String phone = request.getParameter("phone");
		String pswd = request.getParameter("pswd");
		String userName = request.getParameter("userName");
		String address = request.getParameter("address");
		String email = request.getParameter("email");
		
		boolean registFlag = false;
		registFlag = registDao.testName(userName);
		boolean addFlag = false;
		
		List<Object> params = new ArrayList<Object>();
		if (registFlag) {
			params.add(uid);
			params.add(userName);
    		params.add(pswd);
    		params.add(address);
    		params.add(email);
    		params.add(phone);
    		
    		addFlag = registDao.addUser(params);
		}
		
			JSONObject jsonObject = new JSONObject();
			jsonObject.put("result", addFlag);
			jsonObject.put("fff", registFlag);
//			jsonObject.put("eee", params);
			
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
		registDao = new RegistDao();
	}

}
