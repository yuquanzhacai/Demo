package com.edu.scene.test;

import org.apache.http.client.CookieStore;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
/*
* author：冯敏
* description:查看地址列表接口
* */
public class AddressList_Test {
	   @Test(description="查询收货地址成功")
	   public void getAddressList_test() throws  Exception {
		   String url="/fgadmin/address/list";
		   String result2=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,Common.getLoginCookie("20000000004", "netease123"));
//		   JSONObject json=JSONObject.fromObject(result2);
//		   Assert.assertEquals(json.getString("message"),"success");
	   }
	   
	   

}
