package com.sunhao.regist;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class RegistServlet
 */
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private RegistDao registDao = new RegistDao();
   
   // public void init() throws ServletException {
    //	registDao = new RegistDao();
	//}
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RegistServlet() {
        super();
    }

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		super.destroy();
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		String  actionFlag = request.getParameter("ActionFlag");
		String string = "";
	    if (actionFlag!=null) {
	    	if(actionFlag.equals("checkPhone")){//
	    		//检测是否存在该用户
	    		boolean registFlag =false;
	    		String userPhone = request.getParameter("userPhone");
	    		registFlag = registDao.testPhone(userPhone);
	    		if (registFlag) System.out.println("用户可以注册");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(registFlag);
			
	    	}else if(actionFlag.equals("sendIDCode")){
	    		//发送验证码
	    		String userPhone = request.getParameter("userPhone");
	    		
	    		boolean sendFlag = registDao.sendIDCode(userPhone);
	    		if (sendFlag) System.err.println("发送验证码成功");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(sendFlag);
	    		
	    	}else if (actionFlag.equals("checkIDCode")) {
	    		//检测验证码是否正确
	    		String userPhone = request.getParameter("userPhone");
	    		String idCodeClient = request.getParameter("idCodeClient");
	    		boolean testIDCode = registDao.testIDCode(userPhone,idCodeClient);
	    		if (testIDCode) System.out.println("验证码正确");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(testIDCode);
	    		
	    	}else if (actionFlag.equals("regist")) {
	    		//添加该用户的信息
	    		String userPhone = request.getParameter("userPhone");
	    		String pswd = request.getParameter("pswd");
	    		String userName = request.getParameter("userName");
	    		String location = request.getParameter("location");
	    		List<Object> params = new ArrayList<Object>();
	    		params.add(userPhone);
	    		params.add(pswd);
	    		params.add(userName);
	    		params.add(location);
	    		
	    		boolean addFlag = registDao.addUser(params);
	    		if(addFlag) System.out.println("注册成功");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(addFlag);
	    	}else if (actionFlag.equals("changeInfo")){
	    		//修改用户信息(昵称,地址)
	    		String userPhone = request.getParameter("userPhone");
	    		String userName = request.getParameter("userName");
	    		String location = request.getParameter("location");
	    		
	    		List<Object> params =new ArrayList<Object>();
	    		params.add(userName);
	    		params.add(location);
	    		params.add(userPhone);
	    		boolean changeFlag = registDao.changeInfo(params);
	    		if (changeFlag) System.out.println("修改成功");
	    		Gson gson = new Gson();
	    		string = gson.toJson(changeFlag);
	    	}else if (actionFlag.equals("changePswd")){
	    		//修改密码
	    		String userPhone = request.getParameter("userPhoen");
	    		String oldPswd = request.getParameter("oldPswd");
	    		String newPswd =request.getParameter("newPswd");
	    		List<Object> params = new ArrayList<Object>();
	    		params.add(newPswd);
	    		params.add(userPhone);
	    		
	    		boolean testFlag = registDao.testPswd(userPhone,oldPswd);
	    		if (testFlag){
	    			boolean changeFlag = registDao.changePswd(params);
	    			if(changeFlag) System.out.println("修改密码成功");
	    			Gson gson = new Gson();
	    			string = gson.toJson(changeFlag);
	    		}else {
	    			System.out.println("密码不正确");
	    			Gson gson = new Gson();
	    			string = gson.toJson(testFlag);
	    		}
			}
		}
		else {
			System.out.print("null");
		}
	
		byte[] jsonBytes = null;
		try {
			jsonBytes = string.getBytes("utf-8");
			response.setContentType("text/html;charset=utf-8");
			response.setContentLength(jsonBytes.length);
			response.getOutputStream().write(jsonBytes);
			response.getOutputStream().flush();
			response.getOutputStream().close();
			response.setStatus(200);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
}


