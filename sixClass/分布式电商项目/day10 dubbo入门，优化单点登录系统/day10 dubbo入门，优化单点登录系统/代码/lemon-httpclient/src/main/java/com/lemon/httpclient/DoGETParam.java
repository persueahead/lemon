package com.lemon.httpclient;

import java.net.URI;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.utils.URIBuilder;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

public class DoGETParam {

    public static void main(String[] args) throws Exception {

        // ����Httpclient����
        CloseableHttpClient httpclient = HttpClients.createDefault();

        // ��������Ĳ���
        URI uri = new URIBuilder("http://manager.taotao.com/rest/api/content").setParameter("categoryId", "40").
        		setParameter("page", "1").setParameter("rows", "10").build();

        System.out.println(uri);

        // ����http GET����
        HttpGet httpGet = new HttpGet(uri);

        CloseableHttpResponse response = null;
        try {
            // ִ������
            response = httpclient.execute(httpGet);
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
