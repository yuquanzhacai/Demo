package com.edu.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class AddressDelete {
	@Test//执行结果是{"code":400,"message":"请求失败"}400 删除的收货地址 id 不存在 {"code":400,"message":"请求失败"} 
	public void addressDelete() throws IOException, Exception
	{
		String url="/fgadmin/address/delete";
		JSONObject json=new JSONObject();
		json.element("id","77243286");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json,
		Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "请求失败");
	}
}
