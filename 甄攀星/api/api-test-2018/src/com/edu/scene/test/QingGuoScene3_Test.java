package com.edu.scene.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.model.fee;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * description:1、查询收货地址——2、添加收货地址——3、计算运费——4、查询收货地址——5、提交订单
 * */
public class QingGuoScene3_Test {
	@Test(description="查询收货地址",priority=1)//打印两行
	public void getAddressList_test1() throws IOException, Exception
	{
		String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
		JSONObject json=JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("code"), "200");
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
			Assert.assertEquals(json.getString("code"), "400");
		}
	   @Test(description="查询运费信息",priority=3)//打印3行
		public void feeTest() throws Exception {	
			String url="/common/getTransportFee";
			String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000", "netease123"));
			JSONObject json1=JSONObject.fromObject(result);
			JSONObject addrResult=json1.getJSONObject("result");
			JSONArray addlist=addrResult.getJSONArray("list");
			JSONObject list1=addlist.getJSONObject(0);
			String province=list1.getString("province");
			String city=list1.getString("city");
			String area=list1.getString("area");
			String address=province+"_"+city+"_"+area;
			String result1=HttpDriver.fee_Map(ReadPro.getPropValue("BaseUrl")+url,1,address);
			System.out.println(result1);
			JSONObject json= JSONObject.fromObject(result);
			Assert.assertEquals(json.getString("message"), "success");
	 }

			@Test(description="查询收货地址",priority=4)
			public void getAddressList_test2() throws IOException, Exception
			{
				String result=HttpDriver.doGet1(Common.getLoginCookie("20000000000","netease123"));
			
			}
			@Test(description="提交订单",priority=5)//打印3行提交的不是张三的订单
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
