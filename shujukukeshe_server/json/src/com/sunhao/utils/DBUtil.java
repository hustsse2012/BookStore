package com.sunhao.utils;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;






public class DBUtil {
	private  final String DBDRIVER = "com.mysql.jdbc.Driver";
	private  final String DBURL = "jdbc:mysql://localhost:3306/bookstore";
	private  final String DBUSER = "root";
	private  final String DBPASSWORD = "root";
	// 定义数据库的链接
	public Connection conn;
	// 定义sql语句的执行对象
	public PreparedStatement pstmt;
	// 实现批处理操作的功能
	public Statement stmt;
	// 定义查询返回的结果集合
	public ResultSet rs;
	//加载mysql jdbc驱动；
	public DBUtil(){
		try{
			Class.forName(DBDRIVER);
			System.out.println("注册驱动成功!!");
		}catch(ClassNotFoundException e){
			e.printStackTrace();
			System.out.println("加载驱动失败");
		}
	}
	//连接数据库
	public Connection getConnection(){
		try{
			conn = DriverManager.getConnection(DBURL, DBUSER, DBPASSWORD);
		}catch(Exception e){
			e.printStackTrace();
		}
		return conn;
	}
	public boolean deleteResult(String sql)
		throws SQLException{
		boolean flag = false;
		stmt = conn.createStatement();
		int result = -1;
		result = stmt.executeUpdate(sql);
		flag  = result > 0? true:false ;
		return flag;
	}
	//批量删除；
	public boolean deleteByBatch(String[] sql) throws SQLException{
		boolean flag = false;
		stmt = conn.createStatement();
		if(sql != null){
			for(int i=0;i<sql.length;i++){
				stmt.addBatch(sql[i]);
			}
		}
		int[] count = stmt.executeBatch();
		if(count != null){
			flag = true;
		}
		return flag;
	}
	//判断是否执行sql语句操作数据库(statement)方式
	public boolean updateByStatement(String sql) throws SQLException{
		boolean flag = false;
		int result= -1;
		stmt =conn.createStatement();
		result  = stmt.executeUpdate(sql);
		flag = result > 0 ?true:false;
		return flag; 
	}
	//判断是否执行sql语句操作数据库(preparestatement)方式
	public boolean updateByPreparedStatement(String sql,List<Object> params)
			throws SQLException{
		boolean flag = false;
		int result = -1;//表示当用户执行添加删除和修改的时候所影响的数据库的行数
		pstmt = conn.prepareStatement(sql);
		int index = 1;
		if(params != null && !params.isEmpty()){
			for(int i = 0; i < params.size(); i++){
				pstmt.setObject(index++,params.get(i));
			}
		}
		result = pstmt.executeUpdate();
		flag = result > 0?true:false;
		return flag;
	}
	//查询是否存在
	public ResultSet queryResult(String sql) 
			throws SQLException{
		stmt = conn.createStatement();
		rs = stmt.executeQuery(sql);
		return rs;
	}
	//查询返回单条记录
	public Map<String,Object> findSingleResult(String sql,List<Object> params)
			throws SQLException{
		Map<String,Object> map = new HashMap<String,Object>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if(params != null && !params.isEmpty()){
			for(int i = 0;i < params.size();i++){
				pstmt.setObject(index++, params.get(i));
			}
		}
		rs = pstmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int col_len = metaData.getColumnCount();//获得数据表列数
		while (rs.next()){
			for(int i = 0;i < col_len;i++){
				String col_name = metaData.getColumnName(i+1);
				Object col_value = rs.getObject(col_name);
				if(col_value == null){
					col_value ="";
				}
				map.put(col_name, col_value);
			}
		}
		return map;
     }
	//返回多条记录
	public List<Map<String,Object>> findMoreResult(String sql,List<Object> params)
			throws SQLException{
		List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
		int index = 1;
		pstmt = conn.prepareStatement(sql);
		if (params !=null && !params.isEmpty()){
			for(int i = 0 ;i < params.size();i++){
				Object ss=params.get(i);
				pstmt.setObject(index++, params.get(i));
				}
		}
		rs = pstmt.executeQuery();
		ResultSetMetaData metaData = rs.getMetaData();
		int col_len = metaData.getColumnCount();
		while(rs.next()){
			Map<String,Object> map = new HashMap<String,Object>();
			for(int i = 0;i < col_len;i++){
				String col_name = metaData.getColumnName(i+1);
				Object col_value = rs.getObject(col_name);
				if(col_value == null){
					col_value = "";
				}
				map.put(col_name, col_value);
			}
			list.add(map);
		}
		return list;
	}
	// jdbc的封装可以用反射机制来封装：
		public <T> T findSimpleRefResult(String sql, List<Object> params,
				Class<T> cls) throws Exception {
			T resultObject = null;
			int index = 1;
			pstmt = conn.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
					}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (rs.next()) {
				// 通过反射机制创建实例
				resultObject = cls.newInstance();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = rs.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					Field field = cls.getDeclaredField(cols_name);
					field.setAccessible(true);// 打开javabean的访问private权限
					field.set(resultObject, cols_value);
				}
			}
			return resultObject;
		}
		/**
		 * 通过反射机制访问数据库
		 * 
		 * @param <T>
		 * @param sql
		 * @param params
		 * @param cls
		 * @return
		 * @throws Exception
		 */
		public <T> List<T> findMoreRefResult(String sql, List<Object> params,
				Class<T> cls) throws Exception {
			List<T> list = new ArrayList<T>();
			int index = 1;
			pstmt = conn.prepareStatement(sql);
			if (params != null && !params.isEmpty()) {
				for (int i = 0; i < params.size(); i++) {
					pstmt.setObject(index++, params.get(i));
				}
			}
			rs = pstmt.executeQuery();
			ResultSetMetaData metaData = rs.getMetaData();
			int cols_len = metaData.getColumnCount();
			while (rs.next()) {
				T resultObject = cls.newInstance();
				for (int i = 0; i < cols_len; i++) {
					String cols_name = metaData.getColumnName(i + 1);
					Object cols_value = rs.getObject(cols_name);
					if (cols_value == null) {
						cols_value = "";
					}
					Field field = cls.getDeclaredField(cols_name);
					field.setAccessible(true);
					field.set(resultObject, cols_value);
				}
				list.add(resultObject);
			}
			return list;
		}
	public void releaseConn() {
		if (rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (stmt != null) {
			try {
				stmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (pstmt != null) {
			try {
				pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if (conn != null) {
			try {
				conn.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
