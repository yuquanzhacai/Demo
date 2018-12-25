package com.edu.test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
import com.edu.test.Common;
public class AddAddress {
	Checker check;
	@Test(enabled=false)//(priority=0)
	public void login() throws ClientProtocolException, IOException
	{
		//http://study-perf.qa.netease.com//common/fgadmin/login
		String url="/common/fgadmin/login";
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		httpclient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(ReadPro.getPropValue("BaseUrl")+url);
		httpPost.setHeader("Content-Type", "application-json");
		JSONObject info=new JSONObject();
		info.element("phoneArea", "86");
		info.element("phoneNumber", "20000000000");
		info.element("password", "netease123");
//		StringEntity entity=new StringEntity("{\"phoneArea\":\"86\",\"phoneNumber\":\"20000000000\",\"password\":\"netease123\"}","utf-8") ;
		StringEntity entity=new StringEntity(info.toString(),"utf-8");
		httpPost.setEntity(entity);
		response=httpclient.execute(httpPost);
		HttpEntity httpEntity=response.getEntity();
		System.out.println("执行的结果1是："+EntityUtils.toString(httpEntity));
		EntityUtils.consume(httpEntity);
	}
	@Test(dependsOnMethods= {"login"},enabled=false)//priority=1,
	public void AddAddress() throws ClientProtocolException, IOException
	{
		//http://study-perf.qa.netease.com/fgadmin/address/new
		String url="/fgadmin/address/new";	
		CloseableHttpClient httpclient=null;
		CloseableHttpResponse response=null;
		httpclient=HttpClients.createDefault();
		HttpPost httpPost=new HttpPost(ReadPro.getPropValue("BaseUrl")+url);
		httpPost.setHeader("Content-Type", "application-json");
		httpPost.setHeader("csrfToken", "csrfToken");
		JSONObject info=new JSONObject();
		info.element("receiverName","张三");
		info.element("cellPhone","12345678901");
		info.element("addressDetail","浙江大学");
		info.element("province","浙江省");
		info.element("city","杭州市");
		info.element("area","滨江区");
//		StringEntity entity=new StringEntity("{\"receiverName\":\"张三\",\"cellPhone\":\"12345678901\",\"addressDetail\":\"浙江大学\",\"province\":\"浙江省\",\"city\":\"杭州市\",\"area\":\"滨江区\"}","utf-8") ;
		StringEntity entity=new StringEntity(info.toString(),"utf-8");
		httpPost.setEntity(entity);
		response=httpclient.execute(httpPost);
//		response =httpclient.execute(httpPost);
		HttpEntity httpEntity=response.getEntity();
		System.out.println("执行的结果2是："+EntityUtils.toString(httpEntity));
		EntityUtils.consume(httpEntity);
		
	}
	@Test(priority=0)
	public void login1()
	{
		String url="/common/fgadmin/login";
		JSONObject info=new JSONObject();
		info.element("phoneArea", "86");
		info.element("phoneNumber", "20000000000");
		info.element("password", "netease123");
		HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info);
		
	}
	//添加收货地址成功
	@Test(priority=1)
	public void addAddress() throws Exception
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
	@Test //{"message":"请重新登录","code":403}
	public void addressList1() throws Exception
	{
		String url="/fgadmin/address/list";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	@Test//运行报错
	public void getTransportFee() throws Exception
	{
		String url="/common/getTransportFee";
		Map map=new HashMap();
		map.put("id",1);
		map.put("addressDetail","浙江省_杭州市_滨江 区");
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,map);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	@Test
	public void submit() throws IOException, Exception
	{
		String url="/fgadmin/orders/submit";
		JSONObject info=new JSONObject();
		info.element("skuIds","2,3");
		info.element("skuNumbers","1,1");
		info.element("stockIds","74966312,74966313");
		info.element("receiverName","张三");
		info.element("cellPhone","12615813537");
		info.element("addressDetail","1 栋 3 单元");
		info.element( "province","浙江省");
		info.element( "city","杭州市");
		info.element("area","滨江区");
		info.element("voiceStatus",0);
		info.element("needInvoice",0);
		info.element("invoiceHead","");
		info.element("transportFee",0);
		info.element("logisticsCompanyId",1);
		info.element("accessSource","noSource");
		info.element("accessDevice",0);
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info, Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	@Test//执行结果是{"code":400,"message":"请求失败"}400 删除的收货地址 id 不存在 {"code":400,"message":"请求失败"} 
	public void addressDelete() throws IOException, Exception
	{
		String url="/fgadmin/address/delete";
		JSONObject json=new JSONObject();
		json.element("id","77243286");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json,
		Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "success");
	}
	//receiveName参数类型不正确，执行结果是{"message":"success","code":200}
	@Test(priority=1)
	public void addAddress1() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName",123);
		info.element("cellPhone","12345678901");
		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "success");
	}
	//cellPhone参数类型不正确，编译错误
	@Test(priority=1)
	public void addAddress2() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
//		info.element("cellPhone",12345678901);
		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("code"), "400");
//		Assert.assertEquals(json1.getString("message"), "may not be null");
	}
	//addressDetail参数类型不正确，执行结果是{"message":"success","code":200}因为我的字符串是数字类型不是像sjz
	@Test(priority=1)
	public void addAddress3() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
		info.element("cellPhone","12345678901");
		info.element("addressDetail",123);
		//info.element("addressDetail",sjz)
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("code"), "400");
	}
	//province参数类型不正确，执行结果是{"message":"success","code":200}同上
	@Test(priority=1)
	public void addAddress4() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
		info.element("cellPhone","12345678901");
		info.element("addressDetail","Hebei Normal University");
		info.element("province",571);
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("code"), "400");
	}
	//缺少receiverName参数，[TestNG] No tests found. Nothing was run
	public void addAddress5() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
//		info.element("receiverName","receiver");
		info.element("cellPhone","12345678901");
		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("code"), "400");
	}
	//缺少cellPhone参数，执行结果是{"message":"may not be null","code":400}
	@Test(priority=1)
	public void addAddress6() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
//		info.element("cellPhone","12345678901");
		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("code"), "400");

	}
	//缺少addressDetail参数，执行结果是{"message":"may not be null","code":400}
	@Test(priority=1)
	public void addAddress7() throws Exception
	{
		String url="/fgadmin/address/new";
		JSONObject info=new JSONObject();
		info.element("receiverName","receiver");
		info.element("cellPhone","12345678901");
//		info.element("addressDetail","Hebei Normal University");
		info.element("province","Hebei");
		info.element("city","Shijiazhuang");
		info.element("area","Yuhuaqu");
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("code"), "400");
	}
	//缺少province参数，执行结果是{"message":"may not be null","code":400}
		@Test(priority=1)
		public void addAddress8() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","Hebei Normal University");
//			info.element("province","Hebei");
			info.element("city","Shijiazhuang");
			info.element("area","Yuhuaqu");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "400");
		}
		//缺少city参数，执行结果是{"message":"may not be null","code":400}
		@Test(priority=1)
		public void addAddress9() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","Hebei Normal University");
			info.element("province","Hebei");
//			info.element("city","Shijiazhuang");
			info.element("area","Yuhuaqu");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "400");
		}
		//缺少area参数，执行结果是{"message":"may not be null","code":400}
		@Test(priority=1)
		public void addAddress10() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","Hebei Normal University");
			info.element("province","Hebei");
			info.element("city","Shijiazhuang");
//			info.element("area","Yuhuaqu");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "400");
		}
		//直辖市，执行结果是{"message":"success","code":200}
		@Test(priority=1)
		public void addAddress11() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","复旦大学");
			info.element("province","上海市");
			info.element("city","上海市");
			info.element("area","黄浦区");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "200");
		}
		//区不匹配，执行结果是{"message":"success","code":200}
		@Test(priority=1)
		public void addAddress12() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","南京大学");
			info.element("province","江苏省");
			info.element("city","南京市");
			info.element("area","西湖区");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "200");
		}
		//市不匹配，执行结果是{"message":"success","code":200}
		@Test(priority=1)
		public void addAddress13() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","南京大学");
			info.element("province","江苏省");
			info.element("city","杭州市");
			info.element("area","西湖区");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "200");
		}
		//省市区都不匹配，执行结果是{"message":"success","code":200}
		@Test(priority=1)
		public void addAddress14() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","南京大学");
			info.element("province","安徽省");
			info.element("city","南京市");
			info.element("area","西湖区");
			String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			JSONObject json1= JSONObject.fromObject(result);
			Assert.assertEquals(json1.getString("code"), "200");
		}
		//添加已存在的收货地址失败，添加超过6个收货地址失败
		@Test(priority=1)
		public void addAddress15() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","Hebei Normal University");
			info.element("province","Hebei");
			info.element("city","Shijiazhuang");
			info.element("area","Yuhuaqu");
			HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
			
		}
		//添加超过6个收货地址失败
		
		//receiverName参数为"",[TestNG] No tests found. Nothing was run
		public void addAddress16() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","");
			info.element("cellPhone","12345678901");
			info.element("addressDetail","Hebei Normal University");
			info.element("province","Hebei");
			info.element("city","Shijiazhuang");
			info.element("area","Yuhuaqu");
			HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		}
		//cellPhone参数为null,[TestNG] No tests found. Nothing was run
		public void addAddress17() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver");
			info.element("cellPhone","null");
			info.element("addressDetail","Hebei Normal University");
			info.element("province","Hebei");
			info.element("city","Shijiazhuang");
			info.element("area","Yuhuaqu");
			HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		}
	public void addressList() throws Exception
	{
		//ReadPro.getPropValue("BaseUrl")+url
//		this.login1();
		String url="/fgadmin/address/list ";
		HttpDriver.doGet("http://study-perf.qa.netease.com//fgadmin/address/list","goodsId=1");
		
	}
	
	
}
