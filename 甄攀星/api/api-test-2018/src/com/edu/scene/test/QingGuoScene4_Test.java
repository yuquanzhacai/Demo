package com.edu.scene.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * description:1、登录成功——2、查询收货地址——3、删除收货地址——4、添加收货地址——5、查询收货地址——6、计算运费——7、提交订单
 * */
public class QingGuoScene4_Test {
	@Test(description="正常登录情况",dataProvider="login",dataProviderClass=NSDataProvider.class,priority=1)
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
	@Test(description="查询收货地址",priority=2)//打印两行
	public void getAddressList_test1() throws IOException, Exception
	{
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
		JSONObject json=JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("code"), "200");
	}
	@Test(description="删除地址",priority=3)//打印六行执行结果是{"code":400,"message":"请求失败"}400 删除的收货地址 id 不存在 {"code":400,"message":"请求失败"} 
	public void addressDelete_test() throws IOException, Exception
	{
		String url="/fgadmin/address/delete";
		JSONObject json=new JSONObject();
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
		JSONObject json1=JSONObject.fromObject(result);
		JSONObject addrResult=json1.getJSONObject("result");
//		System.out.println(addrResult);
		JSONArray addlist=addrResult.getJSONArray("list");
		JSONObject list1=addlist.getJSONObject(0);
		int id=list1.getInt("id");
//		System.out.println(id);
		json.element("id", id);
		String result1=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json,Common.getLoginCookie("20000000000","netease123"));
		JSONObject json2= JSONObject.fromObject(result);
		Assert.assertEquals(json2.getString("message"), "success");
	}
	@Test(description="添加新地址",priority=4)//打印1行
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
	@Test(description="查询收货地址",priority=5)//打印两行
	public void getAddressList_test2() throws IOException, Exception
	{
		String url="/fgadmin/address/list";	
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000", "netease123"));
		JSONObject json=JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("code"), "200");
	}
	 @Test(description="查询运费信息",priority=6)//打印3行
		public void feeTest() throws Exception {	
			String url="/common/getTransportFee";
			String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000", "netease123"));
			JSONObject json1=JSONObject.fromObject(result);
			JSONObject addrResult=json1.getJSONObject("result");
//			System.out.println(addrResult);
			JSONArray addlist=addrResult.getJSONArray("list");
			JSONObject list1=addlist.getJSONObject(0);
			String province=list1.getString("province");
//			System.out.println(province);
			String city=list1.getString("city");
//			System.out.println(city);
			String area=list1.getString("area");
//			System.out.println(area);
			String address=province+"_"+city+"_"+area;
//			System.out.println(address);
			String result1=HttpDriver.fee_Map(ReadPro.getPropValue("BaseUrl")+url,1,address);
//			System.out.println(address);
			System.out.println(result1);
			JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("message"), "success");
	 }
	@Test(description="提交订单",priority=7)//打印3行提交的不是张三的订单
			public void submit_test() throws IOException, Exception
			{
				String url="/fgadmin/orders/submit";
				String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000", "netease123"));
				JSONObject json1=JSONObject.fromObject(result);
				JSONObject addrResult=json1.getJSONObject("result");
				JSONArray addlist=addrResult.getJSONArray("list");
				JSONObject list1=addlist.getJSONObject(0);
				int id=list1.getInt("id");
//				System.out.println(id);
				int fgUserId=list1.getInt("fgUserId");
				String receiver=list1.getString("receiverName");
				String cellPhone=list1.getString("cellPhone");
				String province=list1.getString("province");
				String city=list1.getString("city");
				String area=list1.getString("area");
				String address=province+"_"+city+"_"+area;
				JSONObject info=new JSONObject();
				info.element("skuIds","2,3");
				info.element("skuNumbers", "1,1");
				info.element("stockIds", "74966312,74966313");
				info.element("receiverName",receiver);
				info.element("cellPhone",cellPhone);
				info.element("addressDetail",address);
				info.element("province", province);
				info.element("city",city);
				info.element("area",area);
				info.element("voiceStatus",0);
				info.element("needInvoice", 0);
				info.element("invoiceHead", "");
				info.element("transportFee",6);
				info.element("logisticsCompanyId", 1);
				info.element("accessSource", "noSource");
				info.element("accessDevice",0);
				String result1=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url, info, Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
				JSONObject json= JSONObject.fromObject(result1);
				Assert.assertEquals(json.getString("code"), "200");
			}

}
