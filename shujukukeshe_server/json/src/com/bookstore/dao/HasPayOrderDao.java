package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.sunhao.utils.DBUtil;

public class HasPayOrderDao {
	private DBUtil jdbcUtil ;
	private ResultSet rs ;
	public HasPayOrderDao(){
		jdbcUtil = new DBUtil();
	}
	public boolean insert(List<Object> params) {
		boolean flag = false;
		String insertSQL = "INSERT INTO order_has_pay(UID,OID,money_should_pay,money_real_pay,pay_time,deliver_time) VALUES(?,?,?,?,?,?)";
		jdbcUtil.getConnection();
		try {
			
			flag = jdbcUtil.updateByPreparedStatement(insertSQL, params);
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
