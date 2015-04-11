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

import com.bookstore.bean.Books;
import com.bookstore.dao.BooksDao;

public class BooksServlet extends HttpServlet {
	
	private String keyword;
	private BooksDao booksDao;
	private String result = "result";
	private String empty = "empty";

	/**
	 * Constructor of the object.
	 */
	public BooksServlet() {
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

		PrintWriter out = response.getWriter();
		request.setCharacterEncoding("utf-8");
//		keyword = request.getParameter("keyword");
		JSONObject resultJsonObject = new JSONObject();
		List<Books> bookList = new ArrayList<Books>();
		 bookList.addAll(booksDao.getBook());
		 JSONArray jsonArray = new JSONArray();
//		 bookList.add(new Books("aaaaacxz","huake",1));
		if(bookList.isEmpty()){
			resultJsonObject.put(result,empty);
		}else{
			for(Books books : bookList){
				JSONObject obj = new JSONObject();
				obj.put("TBID", books.getTBID());
				obj.put("BID", books.getBID());
				obj.put("name",books.getName());
				obj.put("authors",books.getAuthors());
				obj.put("publish", books.getPublish());
				obj.put("price", books.getPrice());
				obj.put("catalogue",books.getCatalogue());
				obj.put("stockNum", books.getStockNum());
				obj.put("supplierID", books.getSupplierID());
				
//				
				jsonArray.add(obj);
			}
			
			resultJsonObject.put(result,jsonArray);
		
		out.print(resultJsonObject.toString());
		out.flush();
		out.close();
		}
	}

	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		booksDao = new BooksDao();
	}

}
