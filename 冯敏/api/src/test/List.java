package test;

import static org.testng.Assert.assertEquals;

import java.io.IOException;

import org.apache.http.client.CookieStore;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.test.Common;
import com.edu.utils.Checker;

import net.sf.json.JSONObject;

public class List {
   public String addressList(String u_name,String u_pwd) throws IOException, Exception {
	   CookieStore cookie=Common.getLoginCookie(u_name, u_pwd);
	   String url="http://study-perf.qa.netease.com/fgadmin/address/list";
//	   String para="tm=1545115234353";
	   String result=HttpDriver.doGet(url,cookie);
	   return result;	   
   }
   @Test(description="查询收货地址成功")
   public void ass() throws IOException, Exception {
	   String mm=addressList("20000000004","netease123");
//	   System.out.println(mm);
	   Checker check=new Checker(mm);
	   check.verifyXpath("message","success");
   }
   @Test(description="查询收货地址失败")
   public void ff() throws IOException, Exception {
	   String mm=addressList("200000000067","netease123");
	   System.out.println(mm);
	   
	   Checker check=new Checker(mm);
	   check.verifyXpath("code","201");
	   
//	   JSONObject json= JSONObject.fromObject(mm);	   
//	   assertEquals(json.getString("code"),"201");
   }
}
