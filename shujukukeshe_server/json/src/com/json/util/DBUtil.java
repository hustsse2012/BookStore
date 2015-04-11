package com.json.util;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
/**连接以及操作数据库*/
public class DBUtil {
	private static Connection conn;
	/**
	 * An object that represents a precompiled(预编译的) SQL statement(声明,语句). A SQL statement is
	 * precompiled and stored in a PreparedStatement object. This object can
	 * then be used to efficiently execute this statement multiple times. Note:
	 * The setter methods (setShort, setString, and so on) for setting IN
	 * parameter values must specify types that are compatible with the defined
	 * SQL type of the input parameter. For instance, if the IN parameter has
	 * SQL type INTEGER, then the method setInt should be used. If arbitrary
	 * parameter type conversions are required, the method setObject should be
	 * used with a target SQL type. In the following example of setting a
	 * parameter, con represents an active connection: PreparedStatement pstmt =
	 * con.prepareStatement("UPDATE EMPLOYEES SET SALARY = ? WHERE ID = ?");
	 * pstmt.setBigDecimal(1, 153833.00) pstmt.setInt(2, 110592) See
	 * Also:Connection.prepareStatement ResultSet
	 */
	private static PreparedStatement pstmt;

	private static String driverClass = "";
	private static String driverUrl = "";
	private static String username = "";
	private static String password = "";

	/**
	 * 获取数据库的连接
	 * 
	 * @return Connection conn
	 */
	public static Connection getConnForMySql() {

		new DBUtil().init();

		try {
			Class.forName(driverClass);
			conn = DriverManager.getConnection(driverUrl, username, password);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return conn;
	}

	/**
	 * 读取paramsConfig.properties属性文件, 这个属性文件里面存放着数据库驱动类的名称,数据库的名称,用户名和密码
	 */
	private void init() {
		Properties pro = new Properties();
		try {
			pro.load(this.getClass().getClassLoader()
					.getResourceAsStream("paramsConfig.properties"));
			driverClass = pro.getProperty("driverClass");
			driverUrl = pro.getProperty("dbUrl");
			username = pro.getProperty("username");
			password = pro.getProperty("password");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**从数据库连接里面获取PreparedStatement对象
	 * @param sql
	 * @return PreparedStatement pstmt
	 */
	public static PreparedStatement getPreparedStatemnt(Connection conn,
			String sql) {
		try {
			pstmt = conn.prepareStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	/**从数据库连接里面获取PreparedStatement对象
	 * @param conn
	 * @param sql
	 * @param params
	 * @return PreparedStatement pstmt
	 */
	public static PreparedStatement getPreparedStatemnt(Connection conn,
			String sql, String params[]) {
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setString(i + 1, params[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	/**
	 * @param conn
	 * @param sql
	 * @param params
	 * @return PreparedStatement pstmt
	 */
	public static PreparedStatement getPreparedStatemnt(Connection conn,
			String sql, Object params[]) {
		try {
			pstmt = conn.prepareStatement(sql);
			for (int i = 0; i < params.length; i++) {
				pstmt.setObject(i + 1, params[i]);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pstmt;
	}

	/**关闭数据库连接
	 * @param conn
	 */
	public static void CloseResources(Connection conn) {
		try {
			if (conn != null && !conn.isClosed())
				conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param stmt
	 */
	public static void CloseResources(Statement stmt) {
		try {
			if (stmt != null)
				stmt.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param rs
	 */
	public static void CloseResources(ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * @param rs
	 */
	public static void CloseResources(ResultSet rs, Statement stmt) {
		CloseResources(rs);
		CloseResources(stmt);
	}

	/**
	 * @param conn
	 * @param stmt
	 */
	public static void CloseResources(Connection conn, Statement stmt) {
		CloseResources(stmt);
		CloseResources(conn);
	}

	/**
	 * @param conn
	 * @param rs
	 */
	public static void CloseResources(Connection conn, ResultSet rs) {
		CloseResources(rs);
		CloseResources(conn);
	}

	/**
	 * @param conn
	 * @param stmt
	 * @param rs
	 */
	public static void CloseResources(Connection conn, Statement stmt,
			ResultSet rs) {
		CloseResources(rs);
		CloseResources(conn, stmt);
	}
}
