package com.webtest.demo;

import java.io.IOException;
import java.net.URL;
import java.net.URLEncoder;

import org.testng.annotations.Test;

import com.gargoylesoftware.htmlunit.FailingHttpStatusCodeException;
import com.gargoylesoftware.htmlunit.HttpMethod;
import com.gargoylesoftware.htmlunit.Page;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.WebRequest;
import com.gargoylesoftware.htmlunit.WebResponse;
import com.webtest.dataprovider.NSDataProvider;

import net.sf.json.JSONObject;

public class jiekou {
	WebClient client=new WebClient();
		
	@Test(description="��¼1���ɹ�",dataProvider="txt2",dataProviderClass=NSDataProvider.class)
	public void denglu(String s1) throws FailingHttpStatusCodeException, IOException{
		String para=s1;
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	
	
	/*@Test(description="��¼1���ɹ�")
	public void denglu() throws FailingHttpStatusCodeException, IOException{
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}*/
	
	@Test(description="��¼2��phoneArea��������ȷ")
	public void login2() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":86,\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	
	@Test(description="��¼4��phoneNumber���Ͳ���ȷ")
	public void login4() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":20000000000,\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	@Test(description="��¼5��ppassword���Ͳ���ȷ")
	public void login5() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":20000000000,\"password\":netease123}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	

	@Test(description="��¼3���û���Ϊ��")
	public void login3() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":\"86\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	@Test(description="��¼6��areaΪ��")
	public void denglu6() throws FailingHttpStatusCodeException, IOException{
		String para="{\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	@Test(description="��¼7��passwordΪ��")
	public void denglu7() throws FailingHttpStatusCodeException, IOException{
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000000\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	
	
	

	
	
	
	
	
	public String doPost(String para) throws FailingHttpStatusCodeException, IOException {
		WebRequest request=new WebRequest(new URL("http://study-perf.qa.netease.com/common/fgadmin/login"),
				HttpMethod.POST);
		client.addRequestHeader("Content-Type","application/json");
		request.setRequestBody(para);
		Page p=client.getPage(request);
		WebResponse response=p.getWebResponse();
		String result=response.getContentAsString();
		return result;
	}
	public String doPost(JSONObject data) throws FailingHttpStatusCodeException, IOException {
		//����һ��JSONObject��ת��String
		String para = URLEncoder.encode(data.toString(), "UTF-8");
		WebRequest request=new WebRequest(new URL("http://study-perf.qa.netease.com/common/fgadmin/login"),
				HttpMethod.POST);
		client.addRequestHeader("Content-Type","application/json");
		request.setRequestBody(para);
		Page p=client.getPage(request);
		WebResponse response=p.getWebResponse();
		String result=response.getContentAsString();
		return result;
	}
		
	
	
}
