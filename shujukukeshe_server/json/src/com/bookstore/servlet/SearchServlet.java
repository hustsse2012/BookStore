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
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import com.bookstore.bean.BookInfo;
import com.bookstore.dao.SearchDao;

public class SearchServlet extends HttpServlet {
	
	private String keyword;
	private SearchDao searchDao;
	private String result = "result";
	private String empty = "empty";

	/**
	 * Constructor of the object.
	 */
	public SearchServlet() {
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
		
		keyword = request.getParameter("keyword");
		keyword = keyword.toLowerCase();
		
		JSONObject resultJsonObject = new JSONObject();
		List<BookInfo> bookList = new ArrayList<BookInfo>();
		 bookList.addAll(searchDao.searchBook(keyword));
		 JSONArray jsonArray = new JSONArray();
//		 bookList.add(new BookInfo("aaaaacxz","java","zhangman","huake",1,
//					null,null,null,5,"A1"));
		if(bookList.isEmpty()){
			resultJsonObject.put(result,empty);
		}else{
			for(BookInfo bookInfo : bookList){
				JSONObject obj = new JSONObject();
				obj.put("TBID", bookInfo.getTBID());
				obj.put("BID", bookInfo.getBID());
				obj.put("name",bookInfo.getName());
				obj.put("authors",bookInfo.getAuthors());
				obj.put("publish", bookInfo.getPublish());
				obj.put("price", bookInfo.getPrice());
				obj.put("catalogue",bookInfo.getCatalogue());
				obj.put("stockNum", bookInfo.getStockNum());
				obj.put("supplierID", bookInfo.getSupplierID());
//				
				jsonArray.add(obj);
			}
			
			resultJsonObject.put(result,jsonArray);
		}
		
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
		searchDao = new SearchDao();
	}

}
