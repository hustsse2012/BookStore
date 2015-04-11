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
	//验证码的随机字符串
	public static final String ALLCHAR = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

	public SendIDCodeUtil() {
		// TODO 自动生成的构造函数存根
	}
	
	public static void sendIDCode(String idCode,String userPhone)
		throws Exception{
		//创建Httpclient客户端的实例
		HttpClient client = new HttpClient();
		//创建postmethod连接方法的实例，url为待连接的地址
		PostMethod postMethod = new PostMethod(url);
		//返回与此httpclient相关的参数，并设置其编码方式
		client.getParams().setContentCharset("gbk");
		//设置传输字符集
		postMethod.addRequestHeader("ContentType","application/x-www-form-urlencoded;charset=gbk");
		String content = new String("您的验证码是：" + idCode + "。请不要把验证码泄露给其他人。"); 
		/*填入各个表单域的值
		 * 在此短信验证平台的登录表单中包含四个域：用户名，密码，要发送的手机号，发送内容
		 */
		NameValuePair[] data = {//提交短信
				new NameValuePair("account", "cf_jiaziang8"),
				new NameValuePair("password", "1234567"),
				new NameValuePair("mobile", userPhone),
				new NameValuePair("content", content) };
		//将表单所有的值设置到PostMethod中用方法setRequestBody
		postMethod.setRequestBody(data);
		//在运行executeMethod方法的时候，需要处理两个异常，分别是HttpException和IOException
		try{
			//执行post方法
			client.executeMethod(postMethod);
			Header[] headers = postMethod.getRequestHeaders();
			//post方法请求过后的状态码，表示网页服务器HTTP响应状态
			int statusCode = postMethod.getStatusCode();
			if (statusCode == 200) {
				System.out.println("statusCode:" + statusCode);
				for(Header h : headers){
					System.out.println(h.toString());
				}
				//取得目标地址的内容,这个方法返回的是String类型
				String result = new String(postMethod.getResponseBodyAsString().getBytes("utf8"));
				//传进来的需要解析的xml格式的string字符串
				Document doc = DocumentHelper.parseText(result); 
				Element root = doc.getRootElement();

				String code = root.elementText("code");	
				String msg = root.elementText("msg");	
				String smsid = root.elementText("smsid");	
				
				System.out.println(code);
				System.out.println(msg);
				System.out.println(smsid);
							
				if(code == "2"){
					System.out.println("短信提交成功");
				}
				System.out.println("result" + result);
			}
		}catch(HttpException e){
			//发生致命的异常，可能是协议不对或者返回的内容有问题
			e.printStackTrace();
		}catch (IOException e) {
			//由于网络原因引起的异常,发生网络异常
			e.printStackTrace();
		}finally{
			//释放连接。无论执行方法是否成功，都必须释放连接
			postMethod.releaseConnection();
		}
	}
	//生成随机验证码(返回一个定长的随机字符串,只包含大小写字母、数字)
	public static String getRandom() {
		//验证码的随机字符串
		//String allChar = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuffer sBuffer =new StringBuffer();
		//Long seed = System.currentTimeMillis();// 获得系统时间，作为生成随机数的种子
		Random random = new Random();// 调用种子生成随机数
		
		for (int i = 0; i < 6; i++) {
			sBuffer.append(ALLCHAR.charAt(random.nextInt(ALLCHAR.length())));
		}
		return sBuffer.toString();
	}
}