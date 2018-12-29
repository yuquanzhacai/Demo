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
		
	@Test(description="登录1：成功",dataProvider="txt2",dataProviderClass=NSDataProvider.class)
	public void denglu(String s1) throws FailingHttpStatusCodeException, IOException{
		String para=s1;
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	
	
	/*@Test(description="登录1：成功")
	public void denglu() throws FailingHttpStatusCodeException, IOException{
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}*/
	
	@Test(description="登录2：phoneArea参数不正确")
	public void login2() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":86,\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	
	@Test(description="登录4：phoneNumber类型不正确")
	public void login4() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":20000000000,\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	@Test(description="登录5：ppassword类型不正确")
	public void login5() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":\"86\",\"phoneNumber\":20000000000,\"password\":netease123}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	

	@Test(description="登录3：用户名为空")
	public void login3() throws FailingHttpStatusCodeException, IOException {
		String para="{\"phoneArea\":\"86\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	@Test(description="登录6：area为空")
	public void denglu6() throws FailingHttpStatusCodeException, IOException{
		String para="{\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}";
		String res=this.doPost(para);
		System.out.println(res);
		client.close();
	}
	@Test(description="登录7：password为空")
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
		//处理一下JSONObject，转成String
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
