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
//���гɹ�
	@Test
	public void test() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","����");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1��3��Ԫ");
        json.element("province","�㽭ʡ");
	    json.element("city","������");
	    json.element("area","������");
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
	    json.element("receiverName","����");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1��3��Ԫ");
        json.element("province","�㽭ʡ");
	    json.element("city","������");
	    json.element("area","������");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("200000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login")); 
	    JSONObject json1 = JSONObject.fromObject(result);
		Assert.assertEquals(json1.getString("message"), "�����µ�¼");
		}
	//����ʧ�ܣ�sku���Ϊ��
	@Test
	public void test2() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","����");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1��3��Ԫ");
        json.element("province","�㽭ʡ");
	    json.element("city","������");
	    json.element("area","������");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "����ʧ��");
		}
	//����ʧ�ܣ�Ҫ�����sku����Ϊ��
	@Test
	public void test3() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","����");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1��3��Ԫ");
        json.element("province","�㽭ʡ");
	    json.element("city","������");
	    json.element("area","������");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "����ʧ��");
		}
	//����ʧ�ܣ��ⷿ����IdΪ��
	@Test
	public void test4() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","");
	    json.element("receiverName","����");
        json.element("cellPhone","12615813537");
	    json.element("addressDetail","1��3��Ԫ");
        json.element("province","�㽭ʡ");
	    json.element("city","������");
	    json.element("area","������");
	    json.element("vocieStatus",0);
        json.element("needInvoice",0);
	    json.element("invoiceHead","");
	    json.element("transportFee",0);
	    json.element("logisticsCompanyId",1);
	    json.element("accessSource","noSource");
	    json.element("assessDevice",0);
	    String result = HttpDriver.doPost(url,json,Common.getLoginCookie("20000000000","netease123","http://study-perf.qa.netease.com//common/fgadmin/login"));
	    JSONObject json1 = JSONObject.fromObject(result);
	    Assert.assertEquals(json1.getString("message"), "����ʧ��");
		}
	//ȱ�ٷǱ���Ԫ�أ����гɹ�
	@Test
	public void test5() throws IOException, Exception {
	    String url = "http://study-perf.qa.netease.com/fgadmin/orders/submit";
		JSONObject json=new JSONObject();
	    json.element("skuIds","2,3");
		json.element("skuNumbers","1,1");
		json.element("stockIds","74966312,74966313");
	    json.element("receiverName","����");
        json.element("cellPhone","");
	    json.element("addressDetail","1��3��Ԫ");
        json.element("province","�㽭ʡ");
	    json.element("city","������");
	    json.element("area","������");
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
