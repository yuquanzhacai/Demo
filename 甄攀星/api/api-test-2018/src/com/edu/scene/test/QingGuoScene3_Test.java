package com.edu.scene.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.model.fee;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

/*
 * description:1、查询收货地址——2、添加收货地址——3、计算运费——4、获取地址列表——5、提交订单
 * */
public class QingGuoScene3_Test {
	@Test(description="查询收货地址",priority=1)
	public void getAddressList_test1() throws IOException, Exception
	{
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
	
	}

	   @Test(description="添加新地址",priority=2)
		public void addAddress_test() throws Exception
		{
			String url="/fgadmin/address/new";
			JSONObject info=new JSONObject();
			info.element("receiverName","receiver123");
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
	   @Test(description="查询运费信息",priority=3)
		public static void feeTest() throws Exception {	
			String url="/common/getTransportFee";
			String result=HttpDriver.fee_Map(ReadPro.getPropValue("BaseUrl")+url,HttpDriver.id,HttpDriver.address);
			System.out.println(result);
			JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("message"), "success");
		}
	   @Test(description="提交订单",priority=5)//提交的是张三的订单"id":82321514
		public void submit_test() throws IOException, Exception
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
			Assert.assertEquals(json.getString("code"), "200");
		}

}
