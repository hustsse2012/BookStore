package com.sunhao.utils;

public class DividePageUtil {
	private int pageSize;  //每页显示的条数
	private int commCount;  //评论总条数
	private int currentPage;  //当前页
	
	public DividePageUtil(int pageSize,int commCount,int currentPage) {
		this.pageSize = pageSize;
		this.commCount = commCount;
		setCurrentPage(currentPage);
	}
	
	public DividePageUtil(int pageSize,int commCount){
		this(pageSize, commCount, 1);
	}

	//获得总页数
	public int getPageCount(){
		int count = commCount/pageSize;
		int mod = commCount%pageSize;
		if (mod != 0) {
			count++;
		}
		return commCount<0 ? 1 : count;
	}
	
	//设置当前页
	public void setCurrentPage(int currentPage){
		//validPage 有效页
		int validPage = currentPage<0 ? 1: currentPage;
		validPage = validPage>getPageCount() ?getPageCount():validPage;
		this.currentPage = validPage;
	}
	
	//设置sql语句的limit子句的两个参数。查询语句有时需返回几条记录，用limit？，？。
	//第一个表示返回开始的位置，第二个表示返回的最大数目（此处开始位置要注意，百度一下你就知道）
	public int getFromIndex(){
		return (currentPage - 1)*pageSize;
	}
	public int getPageSize(){
		return pageSize;
	}

	public int getCommCount() {
		return commCount;
	}

	public void setCommCount(int commCount) {
		this.commCount = commCount;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
}
