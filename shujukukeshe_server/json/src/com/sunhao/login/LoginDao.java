package com.sunhao.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunhao.utils.DBUtil;



public class LoginDao {
	private DBUtil jdbcUtil = null;
	private ResultSet rs = null;
	 public static float money;
	 public static String address;
	//���캯������ʼ��jdbc�������ݿ�
	public LoginDao(){
		jdbcUtil = new DBUtil();
	}
	//��¼��֤
	public int checkLogin(String userPhone,String pswd) {
		//�����ڸ��˺���Ϣ
		int checkFlag = -1;
		
		String sql1 = "select * from t_user where UID='"+userPhone+"'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(sql1);
			//���ڸ��˺�
			if (rs.next()) {
				System.out.println("�����˺�");
				//������ȷ
				String pswd1 = rs.getString("password");
				if ( pswd1.equals(pswd)) {
					checkFlag = 1;
					money = rs.getFloat("user_account_money");
					address = rs.getString("address");
					System.out.println("��¼�ɹ�");
				}else {
					checkFlag = 0;//�������
					System.out.println("�������");
				}
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return checkFlag;
	}
}
