package com.sunhao.login;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONObject;

/**
 * Servlet implementation class LoginServlet
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private LoginDao loginDao = null;
   
    public void init() throws ServletException{
    	loginDao = new LoginDao();
    }
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		// 获取客户端数据
		String userID = request.getParameter("userPhone");
		String pswd = request.getParameter("pswd");
		//根据客户端的用户名和密码检测是否存在用户，若存在密码是否正确
		int flag = loginDao.checkLogin(userID,pswd);
		PrintWriter out = response.getWriter();
		JSONObject js = new JSONObject();
		js.put("flag", flag);
		js.put("money", LoginDao.money);
		js.put("address", LoginDao.address);
		out.print(js.toString());
		out.flush();
		out.close();
		
	}

}
