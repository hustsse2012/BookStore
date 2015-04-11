package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bean.CartInfo;
import com.sunhao.utils.DBUtil;

public class CartDao {
	private DBUtil jdbcUtil ;
	private ResultSet rs ;
	public CartDao() {
		jdbcUtil = new DBUtil();
	}
	public boolean checkIsHave(String userID,String bookID,String bookName) {
		boolean flag = false;
		String sql1 = "select *from t_cartitem where userID = '"+userID+"'"+" and "+"bookID = '"+bookID+"'"+" and "+"bookName = '"+bookName+"'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(sql1);
			while(rs.next())flag = true;
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.releaseConn();
		}
		return flag;
	}
	public boolean update(List<Object> params){
		boolean flag = false;
		String updateCartSQL = "UPDATE t_cartitem SET quantity = quantity + ? WHERE userID =? AND bookID =? AND bookName =?";
		jdbcUtil.getConnection();
		try {
			
			flag = jdbcUtil.updateByPreparedStatement(updateCartSQL, params);
			System.out.print(flag);
			if(flag) System.out.println("更新成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return flag;
	}
	public List<CartInfo> query(String userID){
		String querySQL = "select * from view_getcart_detail where userID='"+userID+"'";
		List<CartInfo> cartsList = new ArrayList<CartInfo>();
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(querySQL);
			//存在该账号
			while(rs.next()) {
				System.out.print(""+rs.getInt("TBID"));
				cartsList.add(new CartInfo(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getFloat(5),rs.getFloat(6),rs.getInt("TBID")));
			} 
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return cartsList;
	}
	public boolean insert(List<Object> params){
		boolean flag = false;
		String insertIntoCartSQL = "INSERT INTO t_cartitem(quantity,userID,bookID,bookName) VALUES(?,?,?,?)";
		jdbcUtil.getConnection();
		try {
			
			flag = jdbcUtil.updateByPreparedStatement(insertIntoCartSQL, params);
			System.out.print(flag);
			if(flag) System.out.println("插入成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return flag;
	}
}
