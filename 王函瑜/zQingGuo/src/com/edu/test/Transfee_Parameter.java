package com.edu.test;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.models.fee;

import net.sf.json.JSONObject;


public class Transfee_Parameter {
	static String result=null;
	static String url="http://study-perf.qa.netease.com/common/getTransportFee";
	
	@Test(description="��ѯ�˷���Ϣ,һ������")
	public void feeTest1() throws Exception {
		String data="id=1&addressDetaile='�㽭ʡ_������_������'";
		String url1=url+"?"+data;
		result=HttpDriver.doGet(url1);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	
	@Test(description="��ѯ�˷���Ϣ,String���Ͳ���")
	public void feeTest2() throws Exception {
		String data="id=1&addressDetaile='�㽭ʡ_������_������'";
		result=HttpDriver.doGet(url,data);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	
	@Test(description="��ѯ�˷���Ϣ,Map����")
	public void feeTest() throws Exception {
		
		result=fee.fee_Map(1,"�㽭ʡ_������_������");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
}
