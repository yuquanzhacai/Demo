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
	@Test(description="�������",dataProvider="login",dataProviderClass=NSDataProvider.class)
	public void testlogin(String a,String b,String c) throws Exception
	{
		String result=this.login(a,b, c);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
		System.out.println(result);
	}
	@Test(description="�������+�˺Ŵ���+�������",dataProvider="login",dataProviderClass=NSDataProvider.class)
	public void testLoginSuccess(String a,String b,String c) throws  Exception
	{

		String url="/common/fgadmin/login";
		JSONObject json=new JSONObject();
		json.element("phoneArea", a);//"86"
		json.element("phoneNumber", b);//"20000000001"
		json.element("password", c);//"netease123"
		String result=HttpDriver.doPost(ReadPro.getPropValue("BaseUrl")+url,json);
		JSONObject json2= JSONObject.fromObject(result);
		Assert.assertEquals(json2.getString("message"), "�û��������������");
		System.out.println(result);
	}
	@Test(description="�쳣1��ȱʧ����")
	public void testLoginFailArea() throws Exception 
	{
		String result=this.login("","20000000000","netease123");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "�û��������������");
		System.out.println(result);
	}
	@Test(description="�쳣2���û���Ϊ��")
	public void testLoginFailName() throws Exception{
		String result=this.login("86","","netease123");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "�û���Ϊ��");
		System.out.println(result);
	}
	@Test(description="�쳣3������Ϊ��")
	public void testLoginFailPSW() throws Exception{
		String result=this.login("86","20000000000","");
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "�û��������������");
		System.out.println(result);
	}
}
