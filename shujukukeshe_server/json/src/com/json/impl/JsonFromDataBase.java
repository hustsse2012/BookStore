package com.json.impl;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import com.json.util.DBUtil;

public class JsonFromDataBase {
	public String getUserInfo(String name) {
		JSONObject userInfos =  new JSONObject();
		JSONArray userArray = new JSONArray();
		String sqlstr = "select * from users where  userName = ?";
		Connection conn = null;
		CallableStatement cs = null;
		ResultSet rs = null;
		try {
			conn = DBUtil.getConnForMySql();
			System.out.println("∆Ù∂Ø≤È—Ø");
			cs =conn.prepareCall(sqlstr,ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY);
			cs.setString(1, name);
			rs = cs.executeQuery();
			while(rs.next()){
				JSONObject userinfo = new JSONObject();
				userinfo.put("id", rs.getString(1));
				userinfo.put("name", rs.getString(2));
				userinfo.put("age", rs.getString(3));
				userinfo.put("sex", rs.getString(4));
				userArray.add(userinfo);
			}
			userInfos.put("users", userArray);
		}catch (Exception e) {
			e.printStackTrace();
		}finally{
			DBUtil.CloseResources(conn, cs);
		}
		return userInfos.toString();
	}

}
