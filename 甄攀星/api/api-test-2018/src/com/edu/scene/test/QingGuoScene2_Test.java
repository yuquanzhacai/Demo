package com.edu.scene.test;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.model.fee;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
/*
 * description：1、登录成功——2、查询收货地址——3、计算运费——4、提交订单
 * */
public class QingGuoScene2_Test {
	@Test(description="正常登录情况",dataProvider="login",dataProviderClass=NSDataProvider.class,priority=0)
	public void login_test(String a,String b,String c) 
	{
		String url="/common/fgadmin/login";
		JSONObject json=new JSONObject();
		json.element("phoneArea", a);
		json.element("phoneNumber", b);
		json.element("password", c);
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json);
		JSONObject json1=JSONObject.fromObject(result);
		Assert.assertEquals(json1.getInt("code"), 200);

	}

	@Test(description="查询收货地址",priority=1)
	public void getAddressList_test() throws IOException, Exception
	{
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
	
	}

		@Test(description="查询运费信息",priority=2)
		public static void feeTest() throws Exception {	
			String url="/common/getTransportFee";
			String result=HttpDriver.fee_Map(ReadPro.getPropValue("BaseUrl")+url,HttpDriver.id,HttpDriver.address);
			System.out.println(result);
			JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("message"), "success");
		}
		@Test(description="提交订单",priority=3)//提交的不是是张三的订单{"message":"may not be null","code":400}
		public void submit_test() throws IOException, Exception
		{
			String url="/fgadmin/orders/submit";
			JSONObject info=new JSONObject();
			info.element("skuIds","2,3");
			info.element("skuNumbers","1,1");
			info.element("stockIds","74966312,74966313");
			info.element("receiverName",HttpDriver.receiver);
			info.element("cellPhone",HttpDriver.cellPhone);
			info.element("addressDetail",HttpDriver.address);
			info.element( "province",HttpDriver.province);
			info.element( "city",HttpDriver.city);
			info.element("area",HttpDriver.area);
			info.element("voiceStatus",0);
			info.element("needInvoice",0);
			info.element("invoiceHead","");
			info.element("transportFee",HttpDriver.fee);
			info.element("logisticsCompanyId",1);
			info.element("accessSource","noSource");
			info.element("accessDevice",0);
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info, Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("code"), "400");
		}
	
}
