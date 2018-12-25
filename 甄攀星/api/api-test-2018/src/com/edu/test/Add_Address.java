package com.edu.test;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;

public class Add_Address {
	Checker check;
	String url = "/fgadmin/address/new";
	String result=null;
//	CookieStore cookies=Common.getLoginCookie("20000000000", "netease123");
	public String addAddress(JSONObject json) throws IOException, Exception
	{
		CookieStore cookies=Common.getLoginCookie("20000000000", "netease123");
		result=HttpDriver.doPost(url, json, cookies);
		return result;
		
	}
	@Test(description="用JSONObject正常成功登录")
	public void addAddress_test1() throws IOException, Exception
	{
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
		info.element("cellPhone","12345678901");
		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		this.addAddress(info);
		
	}
}
