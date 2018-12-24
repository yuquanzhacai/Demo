package demo;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.cookie.Cookie;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.util.EntityUtils;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.test.Common;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
public class jiekouyuansheng {
//运行成功
	@Test
	public void test() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","张三");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1栋3单元");
        json.element("province","浙江省");
	    json.element("city","杭州市");
	    json.element("area","滨江区");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login")); 
	    JSONObject json1 = JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "success");
		}
	@Test
	public void test1() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","张三");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1栋3单元");
        json.element("province","浙江省");
	    json.element("city","杭州市");
	    json.element("area","滨江区");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("200000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login")); 
	    JSONObject json1 = JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "请重新登录");
		}
	//运行失败，sku编号为空
	@Test
	public void test2() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","张三");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1栋3单元");
        json.element("province","浙江省");
	    json.element("city","杭州市");
	    json.element("area","滨江区");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "请求失败");
		}
	//运行失败，要购买的sku个数为空
	@Test
	public void test3() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","张三");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1栋3单元");
        json.element("province","浙江省");
	    json.element("city","杭州市");
	    json.element("area","滨江区");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "请求失败");
		}
	//运行失败，库房批次Id为空
	@Test
	public void test4() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","");
	    json.element("receiverName","张三");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1栋3单元");
        json.element("province","浙江省");
	    json.element("city","杭州市");
	    json.element("area","滨江区");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "请求失败");
		}
	//缺少非必填元素，运行成功
	@Test
	public void test5() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","张三");
        json.element("cellPhone","");
	    json.element("addressDetail","1栋3单元");
        json.element("province","浙江省");
	    json.element("city","杭州市");
	    json.element("area","滨江区");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "success");
		}
}
