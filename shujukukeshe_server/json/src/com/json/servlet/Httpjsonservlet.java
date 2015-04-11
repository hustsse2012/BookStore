package com.json.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.json.impl.JsonFromDataBase;

public class Httpjsonservlet extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2520033558789997695L;
	JsonFromDataBase jsondao = new JsonFromDataBase();
	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {

		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		/**name为客户端请求的参数*/
		String name = request.getParameter("name").toString().trim();
		System.out.println("客户端请求的参数为:"+name);
		String str = null;
		str = jsondao.getUserInfo(name);
		System.out.println("json"+str);
		if(str.equals("noItem")){
			out.print("noItem");
			System.out.println("noItem");
			out.flush();
		}else if(str.equals("pwdError")){
			out.print("pwdError");
			System.out.println("pwdError");
			out.flush();
		}else{
			out.print(str);
			System.out.println(str);
			System.out.println("result");
		}
		
		out.flush();
		out.close();
	}

	
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
}
