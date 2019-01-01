package com.edu.test;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.spare.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
/*
* author：李欣然
* description:提交订单接口
* */
public class Submit_Test {
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
}
