package com.sunhao.utils;

import java.io.IOException;
import java.util.Random;

import org.apache.commons.collections.map.StaticBucketMap;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.omg.CORBA.PUBLIC_MEMBER;

//import com.sun.org.apache.regexp.internal.recompile;


public class SendIDCodeUtil {
	private static String url = "http://106.ihuyi.cn/webservice/sms.php?method=Submit";
	//��֤�������ַ���
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public SendIDCodeUtil() {
		// TODO �Զ����ɵĹ��캯�����
	}
	
	public static void sendIDCode(String idCode,String userPhone)
		throws Exception{
		//����Httpclient�ͻ��˵�ʵ��
		HttpClient client = new HttpClient();
		//����postmethod���ӷ�����ʵ����urlΪ�����ӵĵ�ַ
		PostMethod postMethod = new PostMethod(url);
		//�������httpclient��صĲ���������������뷽ʽ
		client.getParams().setContentCharset("gbk");
		//���ô����ַ���
		postMethod.addRequestHeader("ContentType","application/x-www-form-urlencoded;charset=gbk");
		String content = new String("������֤���ǣ�" + idCode + "���벻Ҫ����֤��й¶�������ˡ�"); 
		/*������������ֵ
		 * �ڴ˶�����֤ƽ̨�ĵ�¼���а����ĸ����û��������룬Ҫ���͵��ֻ��ţ���������
		 */
		NameValuePair[] data = {//�ύ����
				new NameValuePair("account", "cf_jiaziang8"),
				new NameValuePair("password", "1234567"),
				new NameValuePair("mobile", userPhone),
				new NameValuePair("content", content) };
		//�������е�ֵ���õ�PostMethod���÷���setRequestBody
		postMethod.setRequestBody(data);
		//������executeMethod������ʱ����Ҫ���������쳣���ֱ���HttpException��IOException
		try{
			//ִ��post����
			client.executeMethod(postMethod);
			Header[] headers = postMethod.getRequestHeaders();
			//post������������״̬�룬��ʾ��ҳ������HTTP��Ӧ״̬
			int statusCode = postMethod.getStatusCode();
			if (statusCode == 200) {
				System.out.println("statusCode:" + statusCode);
				for(Header h : headers){
					System.out.println(h.toString());
				}
				//ȡ��Ŀ���ַ������,����������ص���String����
				String result = new String(postMethod.getResponseBodyAsString().getBytes("utf8"));
				//����������Ҫ������xml��ʽ��string�ַ���
				Document doc = DocumentHelper.parseText(result); 
				Element root = doc.getRootElement();

				String code = root.elementText("code");	
				String msg = root.elementText("msg");	
				String smsid = root.elementText("smsid");	
				
				System.out.println(code);
				System.out.println(msg);
				System.out.println(smsid);
							
				if(code == "2"){
					System.out.println("�����ύ�ɹ�");
				}
				System.out.println("result" + result);
			}
		}catch(HttpException e){
			//�����������쳣��������Э�鲻�Ի��߷��ص�����������
			e.printStackTrace();
		}catch (IOException e) {
			//��������ԭ��������쳣,���������쳣
			e.printStackTrace();
		}finally{
			//�ͷ����ӡ�����ִ�з����Ƿ�ɹ����������ͷ�����
			postMethod.releaseConnection();
		}
	}
	//���������֤��(����һ������������ַ���,ֻ������Сд��ĸ������)
	public static String getRandom() {
		//��֤�������ַ���
		//String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sBuffer =new StringBuffer();
		//Long seed = System.currentTimeMillis();// ���ϵͳʱ�䣬��Ϊ���������������
		Random random = new Random();// �����������������
		
		for (int i = 0; i < 6; i++) {
			sBuffer.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sBuffer.toString();
	}
}