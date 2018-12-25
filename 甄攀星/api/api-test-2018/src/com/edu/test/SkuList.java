package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class SkuList {
	@Test//"message":"success"
	public void skulist() throws Exception
	{
		String url="/common/skuList";
		String para="goodsId=1";
//		Map<String, Object> para="goodsId=1";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url, para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
}
