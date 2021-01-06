package com.taotao.common.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.entity.ContentType;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.taotao.common.httpclient.HttpResult;

/**
 * 封装get和post请求
 * @author youyuan
 *
 */
@Service
public class ApiService implements BeanFactoryAware{
	@Autowired(required=false)
	private RequestConfig config;
	
	private BeanFactory beanFactory;
	
	private CloseableHttpClient getHttpClient(){
		return beanFactory.getBean(CloseableHttpClient.class);
	}
	
	/**
	 * 带有参数的get请求
	 * @param url
	 * @param params
	 * @return
	 * @throws URISyntaxException
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String doGet(String url,Map<String,String> params) throws URISyntaxException, ClientProtocolException, IOException{
		 URIBuilder uriBuilder = new URIBuilder(url);
		 if(params != null){
			 for(Entry<String, String> en:params.entrySet()){
				 uriBuilder.setParameter(en.getKey(), en.getValue());
			 }
		 }
		 URI uri = uriBuilder.build();	
		return doGet(uri.toString());
	}
	/**
	 * 无参的get请求
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public String doGet(String url) throws ClientProtocolException, IOException{
	        // 创建http GET请求
	        HttpGet httpGet = new HttpGet(url);
	        httpGet.setConfig(config);
	        CloseableHttpResponse response = null;
	        try {
	            // 执行请求
	            response = getHttpClient().execute(httpGet);
	            // 判断返回状态是否为200
	            if (response.getStatusLine().getStatusCode() == 200) {
	                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
	                return content;
	            }
	            return null;
	        } finally {
	            if (response != null) {
	                response.close();
	            }
	        }
	       
	}
	/**
	 * 封装一个没有参数的httpPost请求
	 * @param url
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResult  doPost(String url) throws ClientProtocolException, IOException{
      return doPost(url, null);
	}/**
	 * 有参的httpPost
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResult doPostJson(String url,String jsonStr) throws ClientProtocolException, IOException{
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(config);
        // 构造一个form表单式的实体
        StringEntity formEntity = new StringEntity(jsonStr, ContentType.APPLICATION_JSON);
        // 将请求实体设置到httpPost对象中
        httpPost.setEntity(formEntity);
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = getHttpClient().execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } finally {
            if (response != null) {
                response.close();
            }
        }

	}

	
	
	
	
	/**
	 * 有参的httpPost
	 * @param url
	 * @param params
	 * @return
	 * @throws ClientProtocolException
	 * @throws IOException
	 */
	public HttpResult doPost(String url,Map<String,String> params) throws ClientProtocolException, IOException{
        // 创建http POST请求
        HttpPost httpPost = new HttpPost(url);
        httpPost.setConfig(config);
        if(null != params){
        	 List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        	for(Entry<String, String> en:params.entrySet()){
        		parameters.add(new BasicNameValuePair(en.getKey(), en.getValue()));
        	}
        	// 构造一个form表单式的实体
        	UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
            // 将请求实体设置到httpPost对象中
        	 httpPost.setEntity(formEntity);
        }
        CloseableHttpResponse response = null;
        try {
            // 执行请求
            response = getHttpClient().execute(httpPost);
            return new HttpResult(response.getStatusLine().getStatusCode(), EntityUtils.toString(response.getEntity(), "UTF-8"));
        } finally {
            if (response != null) {
                response.close();
            }
        }

	}

	@Override
	public void setBeanFactory(BeanFactory arg0) throws BeansException {
		beanFactory = arg0;
		
	}
}
