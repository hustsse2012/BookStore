package com.bookstore.dao;

import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import net.sf.json.JSONObject;

import com.bookstore.bean.BookInfo;
import com.bookstore.bean.Books;
import com.sunhao.utils.DBUtil;

public class SearchDao {
	private DBUtil jdbcUtil=null;
	private ResultSet rs = null;
	private String searchSql="select * from t_book where name like ";
	private List<BookInfo> bookList;
	
	public SearchDao() {
		jdbcUtil = new DBUtil();
	}
	
	public List<BookInfo> searchBook(String keyword){
//		String sql="select * from t_book";
		String sql=searchSql+"'%"+keyword+"%'";
//		String sql="select * from t_book where name like %java%";
		bookList = new ArrayList<BookInfo>();
		
		jdbcUtil.getConnection();
		try {
			rs=jdbcUtil.queryResult(sql);
			
			if(rs.next()){
				//÷ÿ∂®œÚ
				rs.previous();
				while(rs.next()){
					
					bookList.add(new BookInfo(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),rs.getString(7),
							rs.getInt(8),rs.getString(9)));
//					rs.next();
				}
				
				return bookList;
//				System.out.print(bookList.toString());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return bookList;
	}
	
}
