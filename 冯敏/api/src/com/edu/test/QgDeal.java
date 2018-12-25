package com.edu.test;

import java.io.IOException;
import java.util.Map;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
public class QgDeal {
	//ʵ��10���û���submit����
	@Test(dataProvider="user",dataProviderClass=NSDataProvider.class)
	public void submit(String name,String password) {
	CookieStore cookie = null;
	try {
		cookie = Common.getLoginCookie(name, password);
	} catch (IOException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	} catch (Exception e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	String url="http://study-perf.qa.netease.com/common/fgadmin/login";
	String para="{\"skuIds\":\"2,3\",\"skuNumbers\":\"1,1\",\"stockIds\":\"74966312,74966313\",\"receiverName\":\"冯敏\",\"cellPhone\":\"12345678910\",\"addressDetail\":\"南二环125号\",\"province\":\"浙江省\",\"city\":\"杭州市\",\"area\":\"滨江区\",\"voiceStatus\":0,\"needInvoice\":0,\"invoiceHead\":\"\",\"transportFee\":0,\"logisticsCompanyId\":1,\"accessSource\":\"noSource\",\"accessDevice\":0}";
	try {
		HttpDriver.doPost(url, para, cookie);
		System.out.println(HttpDriver.doPost(url, para, cookie));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	//���
	
	}


}
