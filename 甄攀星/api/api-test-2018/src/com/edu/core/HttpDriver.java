
package com.edu.core;

import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.CookieStore;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import com.edu.utils.ReadPro;

import bsh.This;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

public class HttpDriver {
	static CloseableHttpClient httpClient = null;
	static CloseableHttpResponse respone = null;

	public static String doGet(String url) throws Exception {
		httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url);
		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println(content);
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}

	public static String doGet(String url, JSONObject data) throws Exception {
		String para = URLEncoder.encode(data.toString(), "UTF-8");
		httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url + "?" + para);
		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}

	public static String doGet(String url, String para) throws Exception {
		httpClient = HttpClients.createDefault();
		HttpGet get = new HttpGet(url + "?" + para);
//		get.addHeader("Content-Type", "application/json");
		respone = httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println(content);
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;
	}

	// 把map类型转换为String,并用&加以拼接
	public static String mapToString(Map<String, Object> para) {
		
				StringBuilder sBuilder = new StringBuilder();
				String content = null;
				int size = para.size();
				for (Entry<String, Object> entry : para.entrySet()) {
					sBuilder.append(entry.getKey() + "=" + entry.getValue());
					size--;
					if (size >= 1) {
						sBuilder.append("&");
					}

				}
				return sBuilder.toString();
	}
	public static String doGet(String url, Map<String, Object> para) {
		String content=null;
		httpClient = HttpClients.createDefault();

		HttpGet get = new HttpGet(url + "?" + mapToString(para));
		get.addHeader("Content-Type", "application/json");
		try {
			respone = httpClient.execute(get);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HttpEntity entity = respone.getEntity();

		try {
			content = EntityUtils.toString(entity, "utf-8");
		} catch (ParseException | IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			EntityUtils.consume(entity);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			respone.close();
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;
	}

//
//	public static String doGet(String url,JOSNObject para) {
//	把JOSNObject转换为String类型
//	}

	public static String doPost(String url, JSONObject para) {
		httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json");
		HttpEntity data;
		String content = null;
		try {
			data = new StringEntity(para.toString());

			post.setEntity(data);
			respone = httpClient.execute(post);

			HttpEntity entity = respone.getEntity();

			content = EntityUtils.toString(entity, "utf-8");
			System.out.println(content);
			EntityUtils.consume(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			respone.close();
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;

	}
	
	public static String doPostByForm(String url, Map<String,Object> para) {
		httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(ReadPro.getPropValue("BaseUrl")+url);
		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
		HttpEntity data;
		String content = null;
		try {
			String s=mapToString(para);
			System.out.println(s);
			data = new StringEntity(s);

			post.setEntity(data);
			respone = httpClient.execute(post);

			HttpEntity entity = respone.getEntity();
			content = EntityUtils.toString(entity, "utf-8");
			EntityUtils.consume(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			respone.close();
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;

	}
	
	public static String doPostByForm(String url, String para) {
		httpClient = HttpClients.createDefault();
		HttpPost post = new HttpPost(ReadPro.getPropValue("BaseUrl")+url);
		post.addHeader("Content-Type", "application/x-www-form-urlencoded");
		HttpEntity data;
		String content = null;
		try {
			data = new StringEntity(para);

			post.setEntity(data);
			respone = httpClient.execute(post);

			HttpEntity entity = respone.getEntity();
			content = EntityUtils.toString(entity, "utf-8");
			EntityUtils.consume(entity);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			respone.close();
			httpClient.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return content;

	}

	public static String doPost(String url, JSONObject para, CookieStore cookie) throws Exception {
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie).build();
		HttpPost post = new HttpPost(url);
		post.addHeader("Content-Type", "application/json");
		HttpEntity data = new StringEntity(para.toString());
		post.setEntity(data);
		CloseableHttpResponse respone = httpClient.execute(post);

		HttpEntity entity = respone.getEntity();
		String content = EntityUtils.toString(entity, "utf-8");
		System.out.println(content);
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;

	}

<<<<<<< HEAD

	public static String doGet1(CookieStore cookie) throws Exception
	{
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie).build();
		HttpGet get=new HttpGet("http://study-perf.qa.netease.com/fgadmin/address/list");
		CloseableHttpResponse response=httpClient.execute(get);
		HttpEntity entity=response.getEntity();
//		if(entity!=null)
//		{
			String address=EntityUtils.toString(entity,"utf-8");
//			System.out.println(address);
			JSONObject json=JSONObject.fromObject(address);
			JSONObject addrResult=json.getJSONObject("result");
			System.out.println(addrResult);
			JSONArray addlist=addrResult.getJSONArray("list");
//			System.out.println(addlist);
			JSONObject list1=addlist.getJSONObject(0);
//		}
		EntityUtils.consume(entity);
		response.close();
		return address;
//	}
	}
	//为了获取地址列表
	public static String content;
	public static String doGet(String url,CookieStore cookie) throws Exception{
	    // 将CookieStore设置到httpClient中
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie).build();
	    httpClient=HttpClients.createDefault();
	    HttpGet get=new HttpGet(url);
	    get.addHeader("Content-Type","aplication/json");
//		get.setHeader(cookie,"mindsparktb_232530392=true;mindsparktbsupport_232530392=true");
	    respone=httpClient.execute(get);
		HttpEntity entity = respone.getEntity();
		if(entity!=null) {
		String content = EntityUtils.toString(entity, "utf-8");
			System.out.println(content);
		}
=======
	//为了获取地址列表
	public static String content;
	public static String doGet(String url,CookieStore cookie) throws Exception{
        // 将CookieStore设置到httpClient中
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie).build();
        httpClient=HttpClients.createDefault();
        HttpGet get=new HttpGet(url);
        get.addHeader("Content-Type","aplication/json");
//		get.setHeader(cookie,"mindsparktb_232530392=true;mindsparktbsupport_232530392=true");
        respone=httpClient.execute(get);
    	HttpEntity entity = respone.getEntity();
    	if(entity!=null) {
    	String content = EntityUtils.toString(entity, "utf-8");
    		System.out.println(content);
    	}
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
		EntityUtils.consume(entity);
		respone.close();
		httpClient.close();
		return content;		
<<<<<<< HEAD
	} 
String url="http://study-perf.qa.netease.com/common/getTransportFee";
public static String fee_Map(String url,int id,String addressDetail) throws Exception 
	{
		Map map = new HashMap();
		map.put("url",url);
		map.put("id", id);
		map.put("addressDetail",addressDetail);
		String result = HttpDriver.doGet(url,map);
		return result;
	}


}

//public static String address;
//public static String addrResult;
//public static double fee;
//public static int id;
//public static String area;
//public static String city;
//public static String province;
//public static int fgUserId;
//public static String cellPhone;
//public static String receiver;
//public static JSONObject json;
=======
} 
	public static String address;
	public static String addrResult;
	public static double fee;
	public static int id;
	public static String area;
	public static String city;
	public static String province;
	public static int fgUserId;
	public static String cellPhone;
	public static String receiver;
	public static JSONObject json;
	public static String doGet1(CookieStore cookie) throws Exception
	{
		RequestConfig gConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD).build();
		httpClient = HttpClients.custom().setDefaultRequestConfig(gConfig).setDefaultCookieStore(cookie).build();
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
		return addrResult;
	}
	
String url="http://study-perf.qa.netease.com/common/getTransportFee";
public static String fee_Map(String url,int id,String addressDetail) throws Exception {
	Map map = new HashMap();
	map.put("url",url);
	map.put("id", id);
	map.put("addressDetail",addressDetail);
	String result = HttpDriver.doGet(url,map);
	return result;
}


}
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
//List<Cookie> cookies =  CookieStore.getCookies();
//for(Cookie cookie : cookies){
//  if(cookie.getName().equalsIgnoreCase(url)){
//      return cookie.getValue();
<<<<<<< HEAD
//  }
//System.out.println(list1);
//String province=list1.getString("province");
//System.out.println(province);
//String city=list1.getString("city");
//System.out.println(city);
//String area=list1.getString("area");
//System.out.println(area);
//address=province+"_"+city+"_"+area;
//System.out.println(address);
//id=list1.getInt("id");
//System.out.println(id);
//fgUserId=list1.getInt("fgUserId");
//cellPhone=list1.getString("cellPhone");
//System.out.println(cell/Phone);
//receiver=list1.getString("receiverName");
//System.out.println(recei/ver);
=======
//  }
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
