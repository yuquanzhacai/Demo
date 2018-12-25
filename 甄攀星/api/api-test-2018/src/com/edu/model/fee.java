package com.edu.model;
import java.util.HashMap;
import java.util.Map;
import com.edu.core.HttpDriver;
public class fee {
	static String url="http://study-perf.qa.netease.com/common/getTransportFee";
	static String result=null;
	public static String fee_Map(int id,String addressDetail) throws Exception {
		Map map = new HashMap();
		map.put("id", id);
		map.put("addressDetail",addressDetail);
		result = HttpDriver.doGet(url,map);
		return result;
	}
	public static String fee_Map_lose(String addressDetail) throws Exception {
		Map map = new HashMap();
		map.put("addressDetail",addressDetail);
		result = HttpDriver.doGet(url,map);
		return result;
	}
	public static String fee_Map_lose2(int id) throws Exception {
		Map map = new HashMap();
		map.put("id",id);
		result = HttpDriver.doGet(url,map);
		return result;
	}

	

	

	

}