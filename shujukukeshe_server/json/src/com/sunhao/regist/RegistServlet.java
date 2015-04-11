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
	    		//����Ƿ���ڸ��û�
	    		boolean registFlag =false;
	    		String userPhone = request.getParameter("userPhone");
	    		registFlag = registDao.testPhone(userPhone);
	    		if (registFlag) System.out.println("�û�����ע��");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(registFlag);
			
	    	}else if(actionFlag.equals("sendIDCode")){
	    		//������֤��
	    		String userPhone = request.getParameter("userPhone");
	    		
	    		boolean sendFlag = registDao.sendIDCode(userPhone);
	    		if (sendFlag) System.err.println("������֤��ɹ�");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(sendFlag);
	    		
	    	}else if (actionFlag.equals("checkIDCode")) {
	    		//�����֤���Ƿ���ȷ
	    		String userPhone = request.getParameter("userPhone");
	    		String idCodeClient = request.getParameter("idCodeClient");
	    		boolean testIDCode = registDao.testIDCode(userPhone,idCodeClient);
	    		if (testIDCode) System.out.println("��֤����ȷ");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(testIDCode);
	    		
	    	}else if (actionFlag.equals("regist")) {
	    		//��Ӹ��û�����Ϣ
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
	    		if(addFlag) System.out.println("ע��ɹ�");
	    		
	    		Gson gson = new Gson();
	    		string = gson.toJson(addFlag);
	    	}else if (actionFlag.equals("changeInfo")){
	    		//�޸��û���Ϣ(�ǳ�,��ַ)
	    		String userPhone = request.getParameter("userPhone");
	    		String userName = request.getParameter("userName");
	    		String location = request.getParameter("location");
	    		
	    		List<Object> params =new ArrayList<Object>();
	    		params.add(userName);
	    		params.add(location);
	    		params.add(userPhone);
	    		boolean changeFlag = registDao.changeInfo(params);
	    		if (changeFlag) System.out.println("�޸ĳɹ�");
	    		Gson gson = new Gson();
	    		string = gson.toJson(changeFlag);
	    	}else if (actionFlag.equals("changePswd")){
	    		//�޸�����
	    		String userPhone = request.getParameter("userPhoen");
	    		String oldPswd = request.getParameter("oldPswd");
	    		String newPswd =request.getParameter("newPswd");
	    		List<Object> params = new ArrayList<Object>();
	    		params.add(newPswd);
	    		params.add(userPhone);
	    		
	    		boolean testFlag = registDao.testPswd(userPhone,oldPswd);
	    		if (testFlag){
	    			boolean changeFlag = registDao.changePswd(params);
	    			if(changeFlag) System.out.println("�޸�����ɹ�");
	    			Gson gson = new Gson();
	    			string = gson.toJson(changeFlag);
	    		}else {
	    			System.out.println("���벻��ȷ");
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


