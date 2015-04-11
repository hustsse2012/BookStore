package com.sunhao.regist;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;






//import com.sun.org.apache.regexp.internal.recompile;
import com.sunhao.utils.DBUtil;
import com.sunhao.utils.SendIDCodeUtil;

public class RegistDao {
	private DBUtil jdbcUtil ;
	//private SendIDCodeUtil sendIDCodeUtil ;
	private ResultSet rs ;
	
	public RegistDao() {
		jdbcUtil = new DBUtil();
		//sendIDCodeUtil = new SendIDCodeUtil();
	}
	//验证能否注册
	public boolean testPhone(String userPhone){
		
		boolean flag = false;
		String sql1 = "select *from userInfoT where userPhone = '"+userPhone+"'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(sql1);
			//检测数据表中是否已存在此手机号
			if(!rs.next())	flag = true;//不存在此手机号
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.releaseConn();
		}
		return flag;
	}
	public boolean sendIDCode(String userPhone){
		boolean flag1 = false;
		boolean flag2 = false;
		String idCodeServer = SendIDCodeUtil.getRandom();
		String sql1 = "select * from CheckT where userPhone='"+userPhone+"'";
		String sql2 = "insert into CheckT(userPhone,idCodeServer) values(?,?)";
		String sql3 = "update CheckT set idCodeServer = '"+idCodeServer+"' where userPhone ='"+userPhone+"'";
		List<Object> params = new ArrayList<Object>();
		params.add(userPhone);
		params.add(idCodeServer);
		try {
			jdbcUtil.getConnection();
			//向CheckT中插入或者更新此次注册的人和验证码
			flag1 = jdbcUtil.queryResult(sql1).next();
			if (flag1) {
				flag2 = jdbcUtil.updateByStatement(sql3);
				if(flag2) System.out.println("添加验证码成功");
			}else {
				flag2 = jdbcUtil.updateByPreparedStatement(sql2, params);
				if(flag2) System.out.println("添加验证码成功");
			}
			//发送验证码
			SendIDCodeUtil.sendIDCode(idCodeServer, userPhone);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag2;
	}
	public boolean testIDCode(String userPhone,String idCodeClient){
		boolean flag = false;
		String sql3 = "select idCodeServer from CheckT where userPhone = '"+userPhone+"'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(sql3);
			rs.next();
			String idCodeServer = rs.getString("idCodeServer");
			//验证码是否正确
			if(idCodeServer.equals(idCodeClient)){
				flag = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	//将注册者的信息存入表中
	public boolean addUser(List<Object> params){
		//addFlag标识是否将注册者的信息存入表中
		boolean addFlag = false;
		String sql = "insert into userInfoT(userPhone,pswd,userName,location,authority) values(?,?,?,?,0)";
		try {
			jdbcUtil.getConnection();
			addFlag = jdbcUtil.updateByPreparedStatement(sql, params);
			if(addFlag) System.out.println("注册成功");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return addFlag;
	}
	//修改用户信息
	public boolean changeInfo(List<Object> params){
		boolean changeFlag = false;
		String sql = "update userInfoT set userName = ?,location = ? where userPhone = ?";
				
		try {
			jdbcUtil.getConnection();
			changeFlag = jdbcUtil.updateByPreparedStatement(sql, params);
			if (changeFlag) System.out.println("修改成功");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.releaseConn();
		}
		return changeFlag;
	}
	//修改密码之前验证密码是否正确
	public boolean testPswd(String userPhone,String oldPswd) {
		boolean testFlag = false;
		String sql = "select pswd from userInfoT where userPhone = '"+userPhone+"'";
		try {
			jdbcUtil.getConnection();
			ResultSet rs = jdbcUtil.queryResult(sql);
			if(rs.getString("pswd") == oldPswd) testFlag =true;
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return testFlag;
	}
	//修改密码
	public boolean changePswd(List<Object> params){
		boolean changeFlag = false;
		String sql2 = "update userInfoT set pswd = ? where userPhone = ? ";
		
		try {
			jdbcUtil.getConnection();
			changeFlag = jdbcUtil.updateByPreparedStatement(sql2,params);
			if(changeFlag) System.out.println("修改成功");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.releaseConn();
		}
		
		return changeFlag;
	}
}
