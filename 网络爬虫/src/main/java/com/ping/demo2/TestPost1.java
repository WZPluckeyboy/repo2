package com.ping.demo2;

import com.sun.org.glassfish.gmbal.NameValue;
import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TestPost1 {
    public static void main(String[] args) {
        //1.打开浏览器
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //2.输入网址
        HttpPost httpPost = new HttpPost("http://www.itcast.cn");
        //1.声明集合
        List<NameValuePair> params=new ArrayList<NameValuePair>();
        params.add(new BasicNameValuePair("keys","Java"));
        CloseableHttpResponse response = null;
        //2.创建表单的实体对象
        try {
        UrlEncodedFormEntity formEntity=new UrlEncodedFormEntity(params,"utf8");
            httpPost.setEntity(formEntity);
            //3.发送请求
            response = httpClient.execute(httpPost);
            //4.解析相应获取数据
            if (response.getStatusLine().getStatusCode() == 200) {
                HttpEntity httpEntity = response.getEntity();
                String content = EntityUtils.toString(httpEntity, "utf8");
                System.out.println(content);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
