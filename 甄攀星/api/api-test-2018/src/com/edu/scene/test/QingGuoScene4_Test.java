package com.edu.scene.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

/*
 * description:1、登录成功——2、查询收货地址——3、删除收货地址——4、添加收货地址——5、查询收货地址——6、计算运费——7、提交订单
 * */
public class QingGuoScene4_Test {
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
	public void getAddressList_test1() throws IOException, Exception
	{
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
	
	}
	@Test(description="删除地址",priority=2)//执行结果是{"code":400,"message":"请求失败"}400 删除的收货地址 id 不存在 {"code":400,"message":"请求失败"} 
	public void addressDelete_test() throws IOException, Exception
	{
		String url="/fgadmin/address/delete";
		JSONObject json=new JSONObject();
		json.element("id",HttpDriver.id);
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json,
		Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
		JSONObject json1= JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "success");
	}
	@Test(description="添加新地址",priority=3)
		public void addAddress_test() throws Exception
		{
				String url="/fgadmin/address/new";
				JSONObject info=new JSONObject();
				info.element("receiverName","receiver456");
				info.element("cellPhone","12345678901");
				info.element("addressDetail","Hebei_Normal_University");
				info.element("province","Hebei");
				info.element("city","Shijiazhuang");
				info.element("area","Yuhuaqu");
				String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
				
				JSONObject json= JSONObject.fromObject(result);
				Assert.assertEquals(json.getString("code"), "200");
		}
	@Test(description="查询收货地址",priority=4)
	public void getAddressList_test2() throws IOException, Exception
	{
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
	
	}
	 @Test(description="查询运费信息",priority=5)
		public static void feeTest() throws Exception {	
			String url="/common/getTransportFee";
			String result=HttpDriver.fee_Map(ReadPro.getPropValue("BaseUrl")+url,HttpDriver.id,HttpDriver.address);
			System.out.println(result);
			JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("message"), "success");
		}
	@Test(description="提交订单",priority=6)//提交的不是张三的订单
			public void submit_test() throws IOException, Exception
			{
				String url="/fgadmin/orders/submit";
				JSONObject info=new JSONObject();
				info.element("id",HttpDriver.id);
				info.element("fgUserId",HttpDriver.fgUserId);
				info.element("area",HttpDriver.area);
				info.element("cellPhone",HttpDriver.cellPhone);
				info.element("city",HttpDriver.city);
				info.element("province", HttpDriver.province);
				info.element("receiverName",HttpDriver.receiver);
				info.element("addressDetail",HttpDriver.address);
				info.element("transportFee",0);
				info.element("needInvoice", 0);
				info.element("invoiceHead", "");
				info.element("totalFee",398);
				info.element("createTime","");//1540634559525
				info.element("logisticsCompanyId", 1);
				info.element("status",0);
				info.element("cancel",0);
				info.element("finish",0);
				info.element("accessSource", "noSource");
				info.element("accessDevice", 0);
				String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info, Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
				JSONObject json= JSONObject.fromObject(result);
				Assert.assertEquals(json.getString("code"), "400");
			}

}
