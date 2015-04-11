package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bean.OrderInfo;
import com.sunhao.utils.DBUtil;

public class OrderDao {

	private DBUtil jdbcUtil ;
	private ResultSet rs ;
	public OrderDao(){
		jdbcUtil = new DBUtil();
	}
	public boolean insert(List<Object> params) {
		boolean flag = false;
		String insertSQL = "INSERT INTO t_order(OID,order_time,del_address,state,money,userID,order_item_count) VALUES(?,?,?,?,?,?,?)";
		jdbcUtil.getConnection();
		try {
			
			flag = jdbcUtil.updateByPreparedStatement(insertSQL, params);
			System.out.print(flag);
			if(flag) System.out.println("插入成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return flag;
	}
	public List<OrderInfo> query(String userID){
		String querySQL = "select * from t_order where userID='"+userID+"'";
		List<OrderInfo> cartsList = new ArrayList<OrderInfo>();
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(querySQL);
			//存在该账号
			while(rs.next()) {
				cartsList.add(new OrderInfo(rs.getString(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5), rs.getString(6), rs.getInt(7)));
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cartsList;
	}

}
