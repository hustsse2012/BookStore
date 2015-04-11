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
	//��֤�ܷ�ע��
	public boolean testPhone(String userPhone){
		
		boolean flag = false;
		String sql1 = "select *from userInfoT where userPhone = '"+userPhone+"'";
		try {
			jdbcUtil.getConnection();
			rs = jdbcUtil.queryResult(sql1);
			//������ݱ����Ƿ��Ѵ��ڴ��ֻ���
			if(!rs.next())	flag = true;//�����ڴ��ֻ���
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
			//��CheckT�в�����߸��´˴�ע����˺���֤��
			flag1 = jdbcUtil.queryResult(sql1).next();
			if (flag1) {
				flag2 = jdbcUtil.updateByStatement(sql3);
				if(flag2) System.out.println("�����֤��ɹ�");
			}else {
				flag2 = jdbcUtil.updateByPreparedStatement(sql2, params);
				if(flag2) System.out.println("�����֤��ɹ�");
			}
			//������֤��
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
			//��֤���Ƿ���ȷ
			if(idCodeServer.equals(idCodeClient)){
				flag = true;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		return flag;
	}
	//��ע���ߵ���Ϣ�������
	public boolean addUser(List<Object> params){
		//addFlag��ʶ�Ƿ�ע���ߵ���Ϣ�������
		boolean addFlag = false;
		String sql = "insert into userInfoT(userPhone,pswd,userName,location,authority) values(?,?,?,?,0)";
		try {
			jdbcUtil.getConnection();
			addFlag = jdbcUtil.updateByPreparedStatement(sql, params);
			if(addFlag) System.out.println("ע��ɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		} finally{
			jdbcUtil.releaseConn();
		}
		return addFlag;
	}
	//�޸��û���Ϣ
	public boolean changeInfo(List<Object> params){
		boolean changeFlag = false;
		String sql = "update userInfoT set userName = ?,location = ? where userPhone = ?";
				
		try {
			jdbcUtil.getConnection();
			changeFlag = jdbcUtil.updateByPreparedStatement(sql, params);
			if (changeFlag) System.out.println("�޸ĳɹ�");
		} catch (Exception e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.releaseConn();
		}
		return changeFlag;
	}
	//�޸�����֮ǰ��֤�����Ƿ���ȷ
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
	//�޸�����
	public boolean changePswd(List<Object> params){
		boolean changeFlag = false;
		String sql2 = "update userInfoT set pswd = ? where userPhone = ? ";
		
		try {
			jdbcUtil.getConnection();
			changeFlag = jdbcUtil.updateByPreparedStatement(sql2,params);
			if(changeFlag) System.out.println("�޸ĳɹ�");
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			jdbcUtil.releaseConn();
		}
		
		return changeFlag;
	}
}
