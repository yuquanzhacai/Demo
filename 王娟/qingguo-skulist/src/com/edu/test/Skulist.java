package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class Skulist{
	
	String url="/common/skuList";
	
	@Test(description="查询全部商品信息成功")
	public void skulist1() throws Exception {
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	
	@Test(description="查询ID为1的商品信息成功")
	public void skulist2() throws Exception{
		String para="goodsId=1";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url, para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	
	@Test(description="查询ID为2147483648的商品信息失败")
	public void skulist3() throws Exception{
		String para="goodsId=2147483648";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url, para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "商品ID不正确");
	}
	
	@Test(description="查询ID为9999的商品信息失败")
	public void skulist4() throws Exception{
		String para="goodsId=9999";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url, para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "商品ID不存在");
	}
	
	@Test(description="查询ID为“1”的商品信息失败")
	public void skulist5() throws Exception{
		String para="goodsId=\"1\"";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url, para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "商品ID参数类型不正确");
	}
}

