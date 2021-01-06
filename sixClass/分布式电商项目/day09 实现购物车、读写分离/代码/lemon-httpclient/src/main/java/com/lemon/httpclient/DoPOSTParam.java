package com.lemon.httpclient;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class DoPOSTParam {

    public static void main(String[] args) throws Exception {

        // ����Httpclient����
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // ����http POST����
        HttpPost httpPost = new HttpPost("http://www.oschina.net/search");

        // αװ�������
        httpPost.setHeader(
                "User-Agent",
                "Mozilla/5.0 (Windows NT 6.3; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/50.0.2661.94 Safari/537.36");

        // ����2��post������һ����scope��һ����q
        List<NameValuePair> parameters = new ArrayList<NameValuePair>(0);
        parameters.add(new BasicNameValuePair("scope", "project"));
        parameters.add(new BasicNameValuePair("q", "java"));
        parameters.add(new BasicNameValuePair("fromerr", "7nXH76r7"));
        // ����һ��form��ʽ��ʵ��
        UrlEncodedFormEntity formEntity = new UrlEncodedFormEntity(parameters);
        // ������ʵ�����õ�httpPost������
        httpPost.setEntity(formEntity);

        CloseableHttpResponse response = null;
        try {
            // ִ������
            response = httpclient.execute(httpPost);
            // �жϷ���״̬�Ƿ�Ϊ200
            if (response.getStatusLine().getStatusCode() == 200) {
                String content = EntityUtils.toString(response.getEntity(), "UTF-8");
                System.out.println(content);
            }
        } finally {
            if (response != null) {
                response.close();
            }
            httpclient.close();
        }

    }

}
