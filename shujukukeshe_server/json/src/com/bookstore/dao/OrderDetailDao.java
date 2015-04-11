package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.bookstore.bean.OrderDetailInfo;
import com.sunhao.utils.DBUtil;

public class OrderDetailDao {
	private  DBUtil jdbcUtils = null;
	private ResultSet rs = null;
	private String sql = "select * from order_detail where ";
	private List<OrderDetailInfo> orderdetailList;
	
	public OrderDetailDao() {
		jdbcUtils = new DBUtil();
	}
	
//	public int orderDetails(String OID,String UID){
//		String detailSql = sql+"OID="+"'"+OID+"'"+" and "+"userID="+"'"+UID+"'";
//		orderdetailList = new ArrayList<OrderDetailInfo>();
//		
//		int flag = -1;
//		
//		jdbcUtils.getConnection();
//		
//		try {
//			rs=jdbcUtils.queryResult(detailSql);
//			
//			if(rs.next()){
//				flag = 5;
//			}else{
//				flag=9;
//			}
//			
////			while(rs.next()){
////				orderdetailList.add(new OrderDetailInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getDate(8),rs.getString(9),rs.getInt(10), rs.getFloat(11),rs.getFloat(12),rs.getDate(13)));
////			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
////		if(!orderdetailList.isEmpty()){
////			flag= 0;
////		}else{
////			flag = 1;
////		}
//		
//		return flag;
//	}
	
	public List<OrderDetailInfo> orderDetails(String OID,String userID){
		String detailSql = sql+"OID="+"'"+OID+"'"+" and "+"userID="+"'"+userID+"'";
		orderdetailList = new ArrayList<OrderDetailInfo>();
		
		jdbcUtils.getConnection();
		
		try {
			rs=jdbcUtils.queryResult(detailSql);
			
			while(rs.next()){
				orderdetailList.add(new OrderDetailInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),rs.getString(8),rs.getInt(9), rs.getString(10),rs.getString(11),rs.getFloat(12)));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return orderdetailList;
	}
	
	
}
