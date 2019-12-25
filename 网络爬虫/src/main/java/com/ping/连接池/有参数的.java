package com.ping.连接池;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class 有参数的 {
    public static void main(String[] args) {
        PoolingHttpClientConnectionManager pool=new PoolingHttpClientConnectionManager();
        // 设置最大连接数
        pool.setMaxTotal(100);
        //2.设置每个主机最大连接数
        pool.setDefaultMaxPerRoute(10);
        doGet(pool);
    }
    public static  void doGet( PoolingHttpClientConnectionManager pool){
        CloseableHttpClient httpClient= HttpClients.custom().setConnectionManager(pool).build();
        HttpGet httpGet=new HttpGet("http://www.itcast.cn");
        RequestConfig requestConfig = RequestConfig.custom()
                .setConnectTimeout(1000)//设置创建连接的最长时间
                .setConnectionRequestTimeout(500)//设置获取连接的最长时间
                .setSocketTimeout(10 * 1000)//设置数据传输的最长时间
                .build();

        httpGet.setConfig(requestConfig);

        CloseableHttpResponse response=null;
        try{
            response=httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                String connect= EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(connect);

            }

        }catch(Exception e){
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
