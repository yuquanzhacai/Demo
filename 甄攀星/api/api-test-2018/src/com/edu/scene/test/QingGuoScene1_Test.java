package com.edu.scene.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.dataprovider.NSDataProvider;
import com.edu.utils.ReadPro;

import net.sf.json.JSONObject;
/*
 * description:1、获取所有商品的sku列表成功——2、获取goodsId=1的商品sku信息成功——3、获取goodsId=2的商品sku信息成功——4、获取goodsId=3的商品sku信息成功
<<<<<<< HEAD
 * ——5、获取goodsId=9999的商品sku信息成功——6、获取goodsId=2147483648的商品sku信息成功
=======
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
 * */
public class QingGuoScene1_Test {
	@Test(description="查询所有的商品列表")//"message":"success"
	public void skulist_test1() throws Exception
	{
		String url="/common/skuList";
//		String para="goodsId=1";
//		Map<String, Object> para="goodsId=1";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getInt("code"), 200);
	}
	@Test(description="查询goodsId=1的商品列表")//"message":"success"
	public void skulist_test2() throws Exception
	{
		String url="/common/skuList";
		String para="goodsId=1";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getInt("code"), 200);
	}
	@Test(description="查询goodsId=2的商品列表")//"message":"success"
	public void skulist_test3() throws Exception
	{
		String url="/common/skuList";
		String para="goodsId=2";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getInt("code"), 200);
	}
	@Test(description="查询goodsId=3的商品列表")//"message":"success"
	public void skulist_test4() throws Exception
	{
		String url="/common/skuList";
		String para="goodsId=3";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,para);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getInt("code"), 200);
	}
	@Test(description="查询goodsId=9999的商品列表")//"message":"success"
	public void skulist_test5() throws Exception
	{
		String url="/common/skuList";
		String para="goodsId=9999";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,para);
		JSONObject json= JSONObject.fromObject(result);
<<<<<<< HEAD
		Assert.assertEquals(json.getInt("code"), 400);
=======
		Assert.assertEquals(json.getInt("code"), 200);
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
	}
	@Test(description="查询goodsId=2147483648的商品列表")//"message":"success"
	public void skulist_test6() throws Exception
	{
		String url="/common/skuList";
		String para="goodsId=2147483648";
		String result=HttpDriver.doGet(ReadPro.getPropValue("BaseUrl")+url,para);
		JSONObject json= JSONObject.fromObject(result);
<<<<<<< HEAD
		Assert.assertEquals(json.getInt("code"), 400);
=======
		Assert.assertEquals(json.getInt("code"), 200);
>>>>>>> e91f6d47701262d6f587e05897172304ee2fa715
	}
}
