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
 * �����˷�
 */


public class TransFeeTest {
	static String result=null;
	static String url="http://study-perf.qa.netease.com/common/getTransportFee";

	@Test(description="��ѯ�˷���Ϣ")
	public void feeTest() throws Exception {		
		result=fee.fee_Map(1,"�㽭ʡ_������_������");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
	
	@Test(description="ȱ��id������addressDetail������ȷ")
	public void feeTest2() throws Exception {
		result=fee.fee_Map_lose("�㽭ʡ_������_������");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
	@Test(description="ȱ��addressDetail������id������ȷ")
	public void feeTest3() throws Exception {
		result=fee.fee_Map_lose2(1);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
	@Test(description="id���ʹ���addressDetail������ȷ")
	public void feeTest4() throws Exception {
		String para="id='1'&addressDetaile='�㽭ʡ_������_������'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
	@Test(description="addressDetaile���ʹ���id������ȷ")
	public void feeTest5() throws Exception {
		String para="id=1&addressDetaile=�㽭ʡ_������_������";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
	//String�մ�
	@Test(description="addressDetaile����Ϊ�մ���id��ȷ")
	public void feeTest6() throws Exception {
		String para="id=1&addressDetaile=''";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
	 
	@Test(description="��ѯʧ�ܣ���Ӧid������")
	public void feeTest7() throws Exception {
		String para="id=0&addressDetaile='�㽭ʡ_������_������'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
	@Test(description="��ѯʧ�ܣ���ӦaddressDetail������")
	public void feeTest8() throws Exception {
		String para="id=1&addressDetaile='�ӱ�ʡ_������_������'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
//	@Test(description="��ѯʧ�ܣ���ӦaddressDetail����ȱ����")
//	public void feeTest10() throws Exception {
//		String para="id=1&addressDetaile='�ӱ�ʡ_������'";
//		result=HttpDriver.doGet(url,para);
//		JSONObject json= JSONObject.fromObject(result);
//		Assert.assertEquals(json.getString("message"), "����ʧ��");
//	}
//	
//	@Test(description="��ѯʧ�ܣ���ӦaddressDetail������")
//	public void feeTest11() throws Exception {
//		String para="id=1&addressDetaile='�ӱ�ʡ_������_������'";
//		result=HttpDriver.doGet(url,para);
//		JSONObject json= JSONObject.fromObject(result);
//		Assert.assertEquals(json.getString("message"), "����ʧ��");
//	}
	
	//����ֵ�����������͵�ȡֵ��Χ
	@Test(description="addressDetaile������ȷ��idȡֵ����intȡֵ��Χ")
	public void feeTest9() throws Exception {
		String para="id=2147483648&addressDetaile='�㽭ʡ_������_������'";
		result=HttpDriver.doGet(url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "����ʧ��");
	}
	
}
