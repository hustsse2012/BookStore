package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sunhao.utils.DBUtil;

public class OrderItemDao {
	private DBUtil jdbcUtil ;
	private ResultSet rs ;
	public OrderItemDao(){
		jdbcUtil = new DBUtil();
	}
	public boolean insert(List<Object> params) {
		boolean flag = false;
		String insertIntoCartSQL = "INSERT INTO t_orderitem(quantity,orderID,bookID,name) VALUES(?,?,?,?)";
		jdbcUtil.getConnection();
		try {
			
			flag = jdbcUtil.updateByPreparedStatement(insertIntoCartSQL, params);
			System.out.print(flag);
			if(flag) System.out.println("≤Â»Î≥…π¶");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return flag;
	}

}
