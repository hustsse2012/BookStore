package com.bookstore.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mysql.jdbc.Connection;
import com.sunhao.utils.DBUtil;





import net.sf.json.JSONObject;

import com.bookstore.bean.BookInfo;
import com.bookstore.bean.Books;

public class BooksDao {
	private DBUtil jdbcUtil=null;
	private ResultSet rs = null;
	private List<Books> bookList;
	
	public BooksDao() {
		jdbcUtil = new DBUtil();
	}
	
	public List<Books> getBook(){
		
//		String sql=searchSql+; //"'"+keyword+"'";
		String sql="select * from t_book limit 0,20";
		bookList = new ArrayList<Books>();
		
		jdbcUtil.getConnection();
		try {
			rs=jdbcUtil.queryResult(sql);
			
			if(rs.next()){
				//÷ÿ∂®œÚ
				rs.previous();
				while(rs.next()){

					bookList.add(new Books(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),rs.getString(5),rs.getFloat(6),
							rs.getString(8),rs.getInt(10),rs.getString(11)));
//					bookList.add(new Books(rs.getString(2),rs.getString(4),rs.getFloat(5)
//							));
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