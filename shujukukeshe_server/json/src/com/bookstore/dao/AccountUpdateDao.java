package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bean.CartInfo;
import com.bookstore.bean.UserAccount;
import com.sunhao.utils.DBUtil;

public class AccountUpdateDao {
	private DBUtil jdbcUtil = null;
	private ResultSet rs = null;

	public AccountUpdateDao() {
		jdbcUtil = new DBUtil();
	}

	// public String updateAccount(String UID){
	//
	// //返回的参数
	// int flag = -1;
	// // String sql =
	// "update view_consumer_user set name='"+name+"',password='"+password+"',address='"+address+"',email='"+phone+"'";
	// // String sql="select * from t_book";
	// String checkSql = "select * from view_consumer_user where UID='"+UID+"'";
	// String updateSql =
	// "update view_consumer_user set name = ?,password = ?,address = ?,email = ?,phone = ? where UID = ?";
	// jdbcUtil.getConnection();
	//
	// try {
	// //检查是否存在UID
	// rs = jdbcUtil.queryResult(checkSql);
	//
	// if(!rs.next()){
	// return rs.getString(2);
	// }else{
	// return "zhagm";
	// }
	// } catch (SQLException e) {
	// e.printStackTrace();
	// }
	//
	// return "aa22";
	// }

	public int updateAccount(String UID, List<Object> params) {

		// 返回的参数
		int flag = -1;
		// String sql =
		// "update view_consumer_user set name='"+name+"',password='"+password+"',address='"+address+"',email='"+phone+"'";
		String checkSql = "select * from t_user where UID='" + UID + "'";
		String updateSql = "update view_consumer_user set name = ?,password = ?,address = ?,email = ?,phone = ? where UID = ?";
		jdbcUtil.getConnection();

		try {
			// 检查是否存在UID
			rs = jdbcUtil.queryResult(checkSql);

			if (!rs.next()) {
				return flag;
			} else {
				boolean updateFlag = false;
				updateFlag = jdbcUtil.updateByPreparedStatement(updateSql,
						params);
				flag = updateFlag == true ? 1 : 0;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return flag;
	}

	public UserAccount query(String userID) {

		String querySQL = "select * from t_user where UID='" + userID + "'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(querySQL);
			// 存在该账号
			while (rs.next()) {
				return new UserAccount(rs.getString(1), rs.getString(2),
						rs.getString(3), rs.getString(4), rs.getString(5),
						rs.getString(6), rs.getInt(7), rs.getFloat(8),
						rs.getFloat(9), rs.getFloat(10));
			}
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return new UserAccount();
	}
}
