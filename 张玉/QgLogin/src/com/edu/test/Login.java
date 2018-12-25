package com.edu.test;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.utils.Checker;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;

public class Login {
	Checker checker;
//	@Test()
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
		String result=this.login(a,b, c);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
		System.out.println(result);
	}
	@Test(description="区间错误+账号错误+密码错误",dataProvider="login",dataProviderClass=NSDataProvider.class)
	public void testLoginSuccess(String a,String b,String c) throws  Exception
	{

		String url="/common/fgadmin/login";
		JSONObject json=new JSONObject();
		json.element("phoneArea", a);//"86"
		json.element("phoneNumber", b);//"20000000001"
		json.element("password", c);//"netease123"
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json);
		JSONObject json2= JSONObject.fromObject(result);
		Assert.assertEquals(json2.getString("message"), "用户名或者密码错误");
		System.out.println(result);
	}
	@Test(description="异常1：缺失区间")
	public void testLoginFailArea() throws Exception 
	{
		String result=this.login("","20000000000","netease123");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "用户名或者密码错误");
		System.out.println(result);
	}
	@Test(description="异常2：用户名为空")
	public void testLoginFailName() throws Exception{
		String result=this.login("86","","netease123");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "用户名为空");
		System.out.println(result);
	}
	@Test(description="异常3：密码为空")
	public void testLoginFailPSW() throws Exception{
		String result=this.login("86","20000000000","");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "用户名或者密码错误");
		System.out.println(result);
	}
}
