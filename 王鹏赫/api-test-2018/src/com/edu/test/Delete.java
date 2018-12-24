package com.edu.test;


import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;
import com.edu.core.HttpDriver;
import net.sf.json.JSONObject;

public class Delete {
	@Test
	public void delete() throws Exception {
		
//		CloseableHttpClient httpclient = HttpClients.createDefault();
		
		CookieStore cookie=Common.getLoginCookie("20000000000","netease123");
		String content=HttpDriver.doGetByCookie("http://study-perf.qa.netease.com/fgadmin/address/list",cookie);
		
		System.out.println(content);
		
		JSONObject json =JSONObject.fromObject(content);
		JSONObject result=json.getJSONObject("result");	
		
		int id1=result.getJSONArray("list").getJSONObject(0).getInt("id");
		System.out.println(id1);
		System.out.println(id1);
		
		JSONObject addressId = new JSONObject();
		addressId.element("id", id1);
		String delete=HttpDriver.doPostByCookie("http://study-perf.qa.netease.com/fgadmin/address/delete",addressId,cookie);
		System.out.println(delete);
		
		

	}
}