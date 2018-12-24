package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;

import net.sf.json.JSONObject;

public class Transfee_Parameter {
	static String result=null;
	static String url="http://study-perf.qa.netease.com/common/getTransportFee";	
	@Test(description="查询运费信息,一个参数")
	public void feeTest1() throws Exception {
		String data="id=1&addressDetaile='浙江省_杭州市_滨江区'";
		String url1=url+"?"+data;
		result=HttpDriver.doGet(url1);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	@Test(description="查询运费信息,String类型参数")
	public void feeTest2() throws Exception {
		String data="id=1&addressDetaile='浙江省_杭州市_滨江区'";
		result=HttpDriver.doGet(url,data);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
//	@Test(description="查询运费信息,Map传参")
//	public void feeTest() throws Exception {
//		result=fee.fee_Map(1,"浙江省_杭州市_滨江区");
//		JSONObject json= JSONObject.fromObject(result);
//		Assert.assertEquals(json.getString("message"), "success");
//	}
}
