package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sunhao.utils.DBUtil;

public class RegistDao {
	private DBUtil jdbcUtil;
	private ResultSet rs;
	
	public RegistDao(){
		jdbcUtil = new DBUtil();
	}
	
	public boolean testName(String userName){
		boolean flag = false;
		String sql1 = "select * from t_user where name = '"+userName+"'";
			jdbcUtil.getConnection();
			try {
				rs = jdbcUtil.queryResult(sql1);
				if(rs.next()){
					flag = false;
				}else{
					flag = true;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return flag;
	}
	public boolean addUser(List<Object> params){
		//addFlag标识是否将注册者的信息存入表中
		boolean addFlag = false;
		String sql = "insert into t_user(UID,name,password,address,email,phone,level,account_balance,money_has_consume,user_account_money) values(?,?,?,?,?,?,null,0,0,5000)";
		try {
			jdbcUtil.getConnection();
			addFlag = jdbcUtil.updateByPreparedStatement(sql, params);
		} catch (SQLException e) {
			e.printStackTrace();
		} 
		return addFlag;
	}
	

}
