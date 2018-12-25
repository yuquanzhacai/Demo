package com.edu.scene.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.test.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class AddAddress_Test {
	@Test(description="添加新地址")
	public void addAddress_test() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
		info.element("cellPhone","12345678901");
		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
}
