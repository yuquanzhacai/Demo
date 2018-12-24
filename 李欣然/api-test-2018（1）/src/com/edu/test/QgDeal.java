package com.edu.test;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;

import net.sf.json.JSONObject;

public class QgDeal {
	//实现10个用户的submit操作
	@Test(dataProvider="user",dataProviderClass=NSDataProvider.class)
	public void submit(String name,String password) {
	//CookieStore cookieStore=Common.getLoginCookie(name, name);
	//HttpDriver.doPost(url, para, cookie)
	//断言
		
	//	CookieStore cook=Common.getLoginCookie(u_name, u_pwd);
		JSONObject json=new JSONObject();
		json.element("id",  1);
		
		
		//HttpDriver.doPost(url, , json,cook);
	
	}

}
