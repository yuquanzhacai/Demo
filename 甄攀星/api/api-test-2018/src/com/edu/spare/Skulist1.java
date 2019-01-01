package com.edu.spare;

import java.net.URLEncoder;

import org.testng.annotations.Test;

import com.edu.core.BaseTest;
import com.edu.core.HttpDriver;
import com.edu.utils.Checker;
/*
 * description：非实训内容
 * */
public class Skulist1 extends BaseTest{
	Checker check;
	String subUrl = "/common/skuList/";
	String result=null;

	public String skulist() throws Exception {
		 result = HttpDriver.doGet(subUrl);
		check = new Checker(result);
		return result;
	}
	
	public String skuListById(String goodsId) throws Exception {
		String result = HttpDriver.doGet(subUrl);
		check = new Checker(result);
		return result;
	}

	@Test(description="查询全部商品信息成功")
	public void Skulist1() throws Exception {
		result = skulist();
		check.verifyXpath("message", "success");
	}

	@Test(description="查询ID为1的商品信息成功")
	public void TestSkuListById1() throws Exception {
		result=this.skuListById("1");
		check.verifyXpath("message", "success");
	}
	
	@Test(description="查询ID为2147483648的商品信息失败")
	public void TestSkuListById2() throws Exception {
		result=this.skuListById("2147483648");
		check.verifyXpath("message", "商品ID不正确");
	}
	
	@Test(description="查询ID为9999的商品信息失败")
	public void TestSkuListById3() throws Exception {
		result=this.skuListById("9999");
		check.verifyXpath("message", "商品ID不存在");
	}
	
	@Test(description="查询ID为“1”的商品信息失败")
	public void TestSkuListByWrongIdType() throws Exception {
		String goodsId=URLEncoder.encode("\"1\"","UTF-8");
		 result=this.skuListById(goodsId);
		check.verifyXpath("message", "商品ID参数类型不正确");
	}

}
