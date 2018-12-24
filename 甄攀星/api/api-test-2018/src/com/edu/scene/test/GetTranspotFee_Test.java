package com.edu.scene.test;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.edu.core.HttpDriver;
import com.edu.model.fee;

import net.sf.json.JSONObject;

public class GetTranspotFee_Test {
	static String result=null;
	static String url="http://study-perf.qa.netease.com/common/getTransportFee";
	
	@Test(description="查询运费信息")
	public void getFee_test() throws Exception {		
		result=fee.fee_Map(1,"浙江省_杭州市_滨江区");
		System.out.println(result);
		JSONObject json= JSONObject.fromObject(result);
		Assert.assertEquals(json.getString("message"), "success");
	}
}

