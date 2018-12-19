package com.edu.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Delete{

public static void main(String[] args) {
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpGet = new HttpGet("http://www.tuicool.com/");
	CloseableHttpResponse response = null;
	try {
		response=httpClient.execute(httpGet);
	} catch (ClientProtocolException e) {  //http协议异常
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {	//io异常
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	HttpEntity entity=response.getEntity();
	try {
		System.out.println("网页内容："+EntityUtils.toString(entity,"utf-8"));
	} catch (ParseException e) {  //解析异常
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {	//io异常
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		response.close();
	} catch (IOException e) {  //io异常
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	try {
		httpClient.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
