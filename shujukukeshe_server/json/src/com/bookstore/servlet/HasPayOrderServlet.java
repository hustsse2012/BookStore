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

import com.bookstore.dao.HasPayOrderDao;

public class HasPayOrderServlet extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private HasPayOrderDao hasPaydao;
	/**
	 * Initialization of the servlet. <br>
	 *
	 * @throws ServletException if an error occurs
	 */
	public void init() throws ServletException {
		hasPaydao = new HasPayOrderDao();
	}
	/**
	 * Constructor of the object.
	 */
	public HasPayOrderServlet() {
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
		String UID = request.getParameter("UID");
		String OID = request.getParameter("OID");
		String money_should_pay = request.getParameter("money_should_pay");
		String money_real_pay = request.getParameter("money_real_pay");
		String pay_time = request.getParameter("pay_time");
		String deliver_time = request.getParameter("deliver_time");
		List<Object> params = new ArrayList<Object>();
		params.add(UID);
		params.add(OID);
		params.add(money_should_pay);
		params.add(money_real_pay);
		params.add(pay_time);
		params.add(deliver_time);
		boolean flag = hasPaydao.insert(params);
		JSONObject js = new JSONObject();
		js.put("flag", flag);
		out.print(js.toString());
		out.flush();
		out.close();
	}



}
