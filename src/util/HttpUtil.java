package util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import net.sf.json.JSONObject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpUtil {
	
	/**
	 * @Description:TODO
	 * @param requestData
	 * @return JSONObject
	 * @author FangRuitao
	 * @throws IOException 
	 * @throws ClientProtocolException 
	 * @date 2016年8月23日
	 */
	public static JSONObject doHttpGet(String requestUrl) throws ClientProtocolException, IOException{
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpget = new HttpGet(requestUrl);
		//发起get请求，并得到请求结果
		CloseableHttpResponse response = httpclient.execute(httpget);
		
		//获取响应实体
		HttpEntity entity = response.getEntity(); 
		
		//获取接口返回的数据
		InputStream instream = entity.getContent();
		InputStreamReader inputStreamReader = new InputStreamReader(instream, "utf-8");
		BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String str = null;
        StringBuffer buffer = new StringBuffer();
        while ((str = bufferedReader.readLine()) != null) {
            buffer.append(str);
        }
        
		//释放资源
		if(bufferedReader!=null){
			try {
				bufferedReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(inputStreamReader!=null){
			try {
				inputStreamReader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(instream!=null){
			try {
				instream.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		if(response!=null){
			try {
				response.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		
		//返回JSON数据
        return JSONObject.fromObject(buffer.toString());
	}
}
