package com.edu.scene.test;

import org.apache.http.client.CookieStore;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.test.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class AddressList_Test {
	
//	 public String addressList(String u_name,String u_pwd) throws  Exception {
//		   CookieStore cookie=Common.getLoginCookie(u_name, u_pwd);
//		   String url="http://study-perf.qa.netease.com/fgadmin/address/list";
//		   String para="tm=1545115234353";
//		   String result=HttpDriver.doGet(url,cookie);
//		   return result;	   
//	   }
	   @Test(description="查询收货地址成功")
	   public void getAddressList_test() throws  Exception {
//		   String result=this.addressList("20000000004","netease123");
//		   System.out.println(result);
//		   JSONObject json=new JSONObject();
//		   JSONObject json= JSONObject.fromObject(result);
//			Assert.assertEquals(json.getString("message"), "success");
//		   Checker check=new Checker(mm);
//		   check.verifyXpath("message", "success");
		   String url="/fgadmin/address/list";
		   String result2=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,Common.getLoginCookie("20000000004", "netease123"));
		   JSONObject json=JSONObject.fromObject(result2);
		   Assert.assertEquals(json.getString("message"),"success");
	   }
	   
	   

}
