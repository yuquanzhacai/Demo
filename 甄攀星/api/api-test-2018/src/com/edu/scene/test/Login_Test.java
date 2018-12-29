package com.edu.scene.test;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
/*
 * author：张玉
 * description:登录接口（数据驱动/原生代码）
 * */
public class Login_Test {
//	Checker checker;
	public String login(String area,String name,String password) throws Exception
	{
		String url="/common/fgadmin/login";		
		JSONObject json =new JSONObject();
		json.element("phoneArea",area);
		json.element("phoneNumber",name);
		json.element("password",password);
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json);
		return result;
	}	
	@Test(description="正常情况",dataProvider="login",dataProviderClass=NSDataProvider.class,enabled=false)
	public void testlogin(String a,String b,String c) throws Exception
	{
		this.login(a,b, c);
	}
	@Test(description="正常登录情况",dataProvider="login",dataProviderClass=NSDataProvider.class)
	public void login_test(String a,String b,String c) throws  Exception
	{
//		String result=this.login(a,b,c);
//		System.out.println(result);
		String url="/common/fgadmin/login";
		JSONObject json=new JSONObject();
		json.element("phoneArea", a);//"86"
		json.element("phoneNumber", b);//"20000000001"
		json.element("password", c);//"netease123"
		HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json);

	}

}
