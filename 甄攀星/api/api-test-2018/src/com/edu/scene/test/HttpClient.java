package com.edu.scene.test;
import java.io.IOException;

import java.io.UnsupportedEncodingException;



import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;

import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.apache.http.util.VersionInfo;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

/*
 * author:甄攀星
 * description:整个场景测试用例写在一个java文件
 * */

public class HttpClient {

	CloseableHttpClient  httpClient =null;

	@BeforeClass

	public void startUp() {

		httpClient= HttpClients.createDefault();

	}

	@AfterClass

	public void tearDown() throws Exception {

		httpClient.close();

	}

	

	public  void doGet(String url) throws ClientProtocolException, IOException {
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response=httpClient.execute(get);
		HttpEntity entity=response.getEntity();
		if(entity!=null)
		{
		
			System.out.println(EntityUtils.toString(entity,"utf-8"));
		}
		String content=EntityUtils.toString(entity,"utf-8");
		EntityUtils.consume(entity);
		response.close();
	}

	public void doPost(String url,JSONObject para) throws Exception {

		HttpPost post=new HttpPost(url);
		post.addHeader("Content-type","application/json");
		StringEntity data=new StringEntity(para.toString());
		post.setEntity(data);
		CloseableHttpResponse response=httpClient.execute(post);
		HttpEntity httpEntity=response.getEntity();
		System.out.println(EntityUtils.toString(httpEntity));
//		String content=EntityUtils.toString(httpEntity);
		EntityUtils.consume(httpEntity);
		response.close();
	}
	

	@Test(priority=0)

	public void loginSuccess() throws Exception {

		JSONObject success_user = new JSONObject();
		success_user.element("phoneArea", "86");
		success_user.element("phoneNumber", "20000000000");
		success_user.element("password", "netease123");
		String url="http://study-perf.qa.netease.com/common/fgadmin/login";
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type","application/json");
		HttpEntity data=new StringEntity(success_user.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println("login"+content);
		EntityUtils.consume(entity);
		respone.close();
	}

	public String address;

	public double fee;
	public int id;
	public String area;
	public String city;
	public String province;
	public int fgUserId;
	public String cellPhone;
	public String receiver;
	@Test(priority=1)
	public void getAddress() throws ClientProtocolException, IOException {
		HttpGet get=new HttpGet("http://study-perf.qa.netease.com/fgadmin/address/list");
		CloseableHttpResponse response=httpClient.execute(get);
		HttpEntity entity=response.getEntity();
		if(entity!=null)
		{
			String address=EntityUtils.toString(entity,"utf-8");
			System.out.println(address);
			JSONObject json=JSONObject.fromObject(address);
			JSONObject addrResult=json.getJSONObject("result");
			System.out.println(addrResult);
			JSONArray addlist=addrResult.getJSONArray("list");
			System.out.println(addlist);
			JSONObject list1=addlist.getJSONObject(0);
			System.out.println(list1);
			String province=list1.getString("province");
			System.out.println(province);
			String city=list1.getString("city");
			System.out.println(city);
			String area=list1.getString("area");
			System.out.println(area);
			address=province+"_"+city+"_"+area;
			System.out.println(address);
			id=list1.getInt("id");
			System.out.println(id);
			fgUserId=list1.getInt("fgUserId");
			cellPhone=list1.getString("cellPhone");
			System.out.println(cellPhone);
			receiver=list1.getString("receiverName");
			System.out.println(receiver);
			
			
		}
		EntityUtils.consume(entity);
		response.close();
	}


	@Test(priority=2)

	public void getFee() throws ClientProtocolException, IOException {
		String url=String.format("http://study-perf.qa.netease.com/common/getTransportFee?id=%d&address=%s",id,address);
		HttpGet get=new HttpGet(url);
		CloseableHttpResponse response=httpClient.execute(get);
		HttpEntity entity=response.getEntity();
		if(entity!=null)
		{
			String feeresult=EntityUtils.toString(entity,"utf-8");
			this.fee=JSONObject.fromObject(feeresult).getDouble("result");
			System.out.println(fee);
		}

	}

	

	@Test(priority=3)

	public void submit() throws Exception {
		HttpPost post = new HttpPost("http://study-perf.qa.netease.com/fgadmin/orders/submit");
		post.addHeader("Content-Type","application/json");
		post.addHeader("csrfToken","csrfToken");
		JSONObject info=new JSONObject();
		info.element("id",id);
		info.element("fgUserId",fgUserId);
		info.element("area",area);
		info.element("cellPhone","cellPhone");
		info.element("city",city);
		info.element("province", province);
		info.element("receiverName","receiver");
		info.element("addressDetail","address");
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
		HttpEntity data=new StringEntity(info.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);	
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println("submit"+content);
		EntityUtils.consume(entity);
		respone.close();

	

	}



}
