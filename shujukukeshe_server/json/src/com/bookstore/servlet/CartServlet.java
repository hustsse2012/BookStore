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

import com.bookstore.dao.CartDao;
import com.google.gson.JsonObject;

public class CartServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CartDao cartDao = null;
    public void init() throws ServletException{
    	cartDao = new CartDao();
    }
	/**
	 * Constructor of the object.
	 */
	public CartServlet() {
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
		String userID = request.getParameter("userPhone");
		String bookID = request.getParameter("bookID");
		String quantity = request.getParameter("quantity");
		String bookName = request.getParameter("bookname");
		List<Object> params = new ArrayList<Object>();
		params.add(quantity);
		params.add(userID);
		params.add(bookID);
		params.add(bookName);
		boolean success;
		if(cartDao.checkIsHave(userID, bookID,bookName)){
			success = cartDao.update(params);
		}else{
			success = cartDao.insert(params);
		}
		
		JSONObject js = new JSONObject();
		js.put("flag", success);
//		cartDao.query();
		PrintWriter out = response.getWriter();
		out.print(js.toString());
		out.flush();
		out.close();
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */

}
