package com.project.Utile;

import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.util.EntityUtils;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.UUID;

@Component
public class Httputile {
    private PoolingHttpClientConnectionManager cm;
    public Httputile(){
        this.cm=new PoolingHttpClientConnectionManager();
        cm.setMaxTotal(200);
        cm.setDefaultMaxPerRoute(20);
    }
    public String doGetHtml(String url){
        //获取页面数据
      CloseableHttpClient httpClient= HttpClients.custom().setConnectionManager(cm).build();
      HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response=null;
        try {
           response= httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                if(response.getEntity() !=null){
                String content=  EntityUtils.toString(response.getEntity(),"utf8");
                return content;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  "";
    }
    public String doGetImg(String url){
        CloseableHttpClient httpClient= HttpClients.custom().setConnectionManager(cm).build();
        HttpGet httpGet=new HttpGet(url);
        CloseableHttpResponse response=null;
        try {
            response= httpClient.execute(httpGet);
            if(response.getStatusLine().getStatusCode()==200){
                if(response.getEntity() !=null){
                   String extName=url.substring(url.lastIndexOf("."));
                   String picName= UUID.randomUUID().toString()+extName;
                    OutputStream out=new FileOutputStream(new File("C:\\Users\\ASUS\\Desktop\\Image\\"+picName));
                   response.getEntity().writeTo(out);
                   return picName;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return  "";
    }
    private RequestConfig getConfig() {
        RequestConfig config = RequestConfig.custom().setConnectTimeout(1000).
                setConnectionRequestTimeout(500).
                setSocketTimeout(10000).build();
        return config;
    }
}
