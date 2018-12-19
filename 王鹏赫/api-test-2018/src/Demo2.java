

import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class Demo2 {
	public static void main(String[] args)throws Exception{
	CloseableHttpClient httpClient = HttpClients.createDefault();
	HttpGet httpGet = new HttpGet("http://study-perf.qa.netease.com/buy/index.html#/login");
	httpGet.setHeader("User-Agent","Mozilla/5.0 (Windows NT 10.0; Win64; x64; rv:56.0) Gecko/20100101 Firefox/56.0");
	CloseableHttpResponse response = null;
	response=httpClient.execute(httpGet);
	System.out.println("Status:"+response.getStatusLine());
	HttpEntity entity=response.getEntity();
	//System.out.println("Content-Type:"+entity.getContentType().getValue());
	//System.out.println("网页内容："+EntityUtils.toString(entity,"utf-8"));
	response.close();
	httpClient.close();	
	}
}
