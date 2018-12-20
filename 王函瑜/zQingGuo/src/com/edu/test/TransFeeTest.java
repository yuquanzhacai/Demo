package com.edu.test;

import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.models.fee;

import net.sf.json.JSONObject;

/*
 * author:wanghanyu
 * 计算运费
 */


public class TransFeeTest {
	static String result=null;
	static String url="http://study-perf.qa.netease.com/common/getTransportFee";

	@Test(description="查询运费信息")
	public void feeTest() throws Exception {		
		result=fee.fee_Map(1,"浙江省_杭州市_滨江区");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	
	@Test(description="缺少id参数，addressDetail参数正确")
	public void feeTest2() throws Exception {
		result=fee.fee_Map_lose("浙江省_杭州市_滨江区");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
	@Test(description="缺少addressDetail参数，id参数正确")
	public void feeTest3() throws Exception {
		result=fee.fee_Map_lose2(1);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
	@Test(description="id类型错误，addressDetail参数正确")
	public void feeTest4() throws Exception {
		String para="id='1'&addressDetaile='浙江省_杭州市_滨江区'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
	@Test(description="addressDetaile类型错误，id参数正确")
	public void feeTest5() throws Exception {
		String para="id=1&addressDetaile=浙江省_杭州市_滨江区";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
	//String空串
	@Test(description="addressDetaile参数为空串，id正确")
	public void feeTest6() throws Exception {
		String para="id=1&addressDetaile=''";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
	 
	@Test(description="查询失败，对应id不存在")
	public void feeTest7() throws Exception {
		String para="id=0&addressDetaile='浙江省_杭州市_滨江区'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
	@Test(description="查询失败，对应addressDetail不存在")
	public void feeTest8() throws Exception {
		String para="id=1&addressDetaile='河北省_杭州市_滨江区'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
//	@Test(description="查询失败，对应addressDetail参数缺少区")
//	public void feeTest10() throws Exception {
//		String para="id=1&addressDetaile='河北省_杭州市'";
//		result=HttpDriver.doGet(url,para);
//		JSONObject json= JSONObject.fromObject(result);
//		Assert.assertEquals(json.getString("message"), "请求失败");
//	}
//	
//	@Test(description="查询失败，对应addressDetail不存在")
//	public void feeTest11() throws Exception {
//		String para="id=1&addressDetaile='河北省_杭州市_滨江区'";
//		result=HttpDriver.doGet(url,para);
//		JSONObject json= JSONObject.fromObject(result);
//		Assert.assertEquals(json.getString("message"), "请求失败");
//	}
	
	//参数值超出数据类型的取值范围
	@Test(description="addressDetaile参数正确，id取值超出int取值范围")
	public void feeTest9() throws Exception {
		String para="id=2147483648&addressDetaile='浙江省_杭州市_滨江区'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "请求失败");
	}
	
}
