package com.edu.test;

import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class Login {
	Checker checker;
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
	@Test(description="正常情况",dataProvider="login",dataProviderClass=NSDataProvider.class)
	public void testlogin(String a,String b,String c) throws Exception
	{
		this.login(a,b, c);
	}
	@Test(description="正常情况",dataProvider="login",dataProviderClass=NSDataProvider.class)
	public void testLoginSuccess(String a,String b,String c) throws  Exception
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
	
	//原来函数中的代码username userpassword接口文档写的是phoneNumber，password
//	String url="/common/fgadmin/login";		
//	JSONObject json =new JSONObject();
//	json.element("phoneArea",area);
//	json.element("username",name);
//	json.element("userpassword",password);
//	String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json);
//	return result;
	@Test(description="异常1：缺失区间")
	public void testLoginFailArea() throws Exception 
	{
		String result=this.login("","20000000000","netease123");
		System.out.println(result);
	}
	@Test(description="异常2：用户名为空")
	public void testLoginFailName() throws Exception{
		String result=this.login("86","","netease123");
		System.out.println(result);
	}
	@Test(description="异常3：密码为空")
	public void testLoginFailPSW() throws Exception{
		String result=this.login("86","20000000000","");
		System.out.println(result);
	}
}
