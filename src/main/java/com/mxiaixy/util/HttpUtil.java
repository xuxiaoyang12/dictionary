package com.mxiaixy.util;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mxia on 2016/12/6.
 */
public class HttpUtil {


    public static String sendHttpGetRequest(String url){

        //ajax 请求外域servlet
        //使用代理模式
        //网络编程

        //创建一个能发出请求的客户端
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建一个get请求
        HttpGet httpGet = new HttpGet(url);

        try {
            //发送请求并接受服务端响应
            HttpResponse response = httpClient.execute(httpGet);
            //获取服务端的状态码
            int status = response.getStatusLine().getStatusCode();
            if(status==200){
                //接受响应输入流
                InputStream inputStream = response.getEntity().getContent();
                //把响应输入流转成字符串  并且字符编码是UTF-8
                String result = IOUtils.toString(inputStream,"UTF-8");
                inputStream.close();
                httpClient.close();
                return result;
            }else{
                throw new RuntimeException("服务器异常"+status);
            }

        } catch (IOException e) {
            throw new RuntimeException("服务器异常");
        }


    }


}
