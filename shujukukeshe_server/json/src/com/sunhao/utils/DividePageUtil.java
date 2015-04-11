package com.sunhao.utils;

public class DividePageUtil {
	private int pageSize;  //ÿҳ��ʾ������
	private int commCount;  //����������
	private int currentPage;  //��ǰҳ
	
	public DividePageUtil(int pageSize,int commCount,int currentPage) {
		this.pageSize = pageSize;
		this.commCount = commCount;
		setCurrentPage(currentPage);
	}
	
	public DividePageUtil(int pageSize,int commCount){
		this(pageSize, commCount, 1);
	}

	//�����ҳ��
	public int getPageCount(){
		int count = commCount/pageSize;
		int mod = commCount%pageSize;
		if (mod != 0) {
			count++;
		}
		return commCount<0 ? 1 : count;
	}
	
	//���õ�ǰҳ
	public void setCurrentPage(int currentPage){
		//validPage ��Чҳ
		int validPage = currentPage<0 ? 1: currentPage;
		validPage = validPage>getPageCount() ?getPageCount():validPage;
		this.currentPage = validPage;
	}
	
	//����sql����limit�Ӿ��������������ѯ�����ʱ�践�ؼ�����¼����limit��������
	//��һ����ʾ���ؿ�ʼ��λ�ã��ڶ�����ʾ���ص������Ŀ���˴���ʼλ��Ҫע�⣬�ٶ�һ�����֪����
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
