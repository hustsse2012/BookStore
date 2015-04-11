package com.sunhao.login;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.sunhao.utils.DBUtil;



public class LoginDao {
	private DBUtil jdbcUtil = null;
	private ResultSet rs = null;
	 public static float money;
	 public static String address;
	//构造函数，初始化jdbc连接数据库
	public LoginDao(){
		jdbcUtil = new DBUtil();
	}
	//登录验证
	public int checkLogin(String userPhone,String pswd) {
		//不存在该账号信息
		int checkFlag = -1;
		
		String sql1 = "select * from t_user where UID='"+userPhone+"'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(sql1);
			//存在该账号
			if (rs.next()) {
				System.out.println("存在账号");
				//密码正确
				String pswd1 = rs.getString("password");
				if ( pswd1.equals(pswd)) {
					checkFlag = 1;
					money = rs.getFloat("user_account_money");
					address = rs.getString("address");
					System.out.println("登录成功");
				}else {
					checkFlag = 0;//密码错误
					System.out.println("密码错误");
				}
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return checkFlag;
	}
}
