package com.edu.scene.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
/*
 * author：王鹏赫
 * description:删除地址接口
 * */
public class AddressDelete_Test {
	//必须之前查看addressList的id
	@Test(description="删除地址")//执行结果是{"code":400,"message":"请求失败"}400 删除的收货地址 id 不存在 {"code":400,"message":"请求失败"} 
	public void addressDelete_test() throws IOException, Exception
	{
		String url="/fgadmin/address/delete";
		JSONObject json=new JSONObject();
<<<<<<< HEAD
		json.element("id","82321612");
=======
		json.element("id","82321493");
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json,
		Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "success");
	}
}
