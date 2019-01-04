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
import com.webtest.utils.ReadPro;

import net.sf.json.JSONObject;

public class QgLogin {
	WebClient client=new WebClient();
	public String login(String Area,String name,String password) throws IOException, Exception
	{
		String url="/common/fgadmin/login";
		JSONObject json =new JSONObject();
		json.element("phoneArea",Area);
		json.element("username",name);
		json.element("userpassword",password);
		String result=this.doPost(ReadPro.getPropValue("BaseUrl")+url,json);
		return result;
		
	}
	//重写doPost
	public String doPost(String url,JSONObject data) throws FailingHttpStatusCodeException, IOException {
		//处理一下JSONObject，转成String
		String para = URLEncoder.encode(data.toString(), "UTF-8");
		WebRequest request=new WebRequest(new URL(url),
				HttpMethod.POST);
		client.addRequestHeader("Content-Type","application/json");
		request.setRequestBody(para);
		Page p=client.getPage(request);
		WebResponse response=p.getWebResponse();
		String result=response.getContentAsString();
		return result;
	}
	
	@Test(description="测试登录成功界面")
	public void LoginSuccess() throws IOException, Exception {
		login("86", "20000000000", "netease123");
	}
}
