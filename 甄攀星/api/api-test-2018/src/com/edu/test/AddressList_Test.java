package com.edu.test;

import org.apache.http.client.CookieStore;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.spare.Common;

import net.sf.json.JSONObject;
/*
* author：冯敏
* description:查看地址列表接口
* */
public class AddressList_Test {
	
	 public String addressList(String u_name,String u_pwd) throws  Exception {
		   CookieStore cookie=Common.getLoginCookie(u_name, u_pwd);
		   String url="http://study-perf.qa.netease.com/fgadmin/address/list";
//		   String para="tm=1545115234353";
		   String result=HttpDriver.doGet(url,cookie);
		   return result;	   
	   }
	   @Test(description="查询收货地址成功")
	   public void getAddressList_success() throws  Exception {
		   String result=addressList("2000000000","netease123");
		   System.out.println(result);
//		   JSONObject json=new JSONObject();
		   JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("message"), "success");
//		   Checker check=new Checker(mm);
//		   check.verifyXpath("message", "success");
	   }
	   @Test(description="查询收货地址失败",enabled=false)//地址为空,需要自己设置
	   public void getAddressList_fail() throws Exception {
		   String mm=addressList("20000000000","netease123");
		   System.out.println(mm);
//		   Checker check=new Checker(mm);
//		   check.verifyXpath("code", "201");

	   }
}
