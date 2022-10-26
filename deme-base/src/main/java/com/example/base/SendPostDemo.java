package com.example.base;
/**
 * 使用jdk自带的HttpURLConnection向URL发送POST请求并输出响应结果
 * 参数使用流传递，并且硬编码为字符串"name=XXX"的格式
 */

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;

@Component
public class SendPostDemo {

    @Value("${token}")
    private String Token;

    public String SendPOST(String url1,String param) throws IOException {

        String urlPath = new String(url1);
        //String urlPath = new String("http://localhost:8080/Test1/HelloWorld?name=丁丁".getBytes("UTF-8"));
        //建立连接
        URL url = new URL(urlPath);
        HttpURLConnection httpConn = (HttpURLConnection) url.openConnection();
        //设置参数

        httpConn.setDoOutput(true);   //需要输出
        httpConn.setDoInput(true);   //需要输入
        httpConn.setUseCaches(false);  //不允许缓存
        httpConn.setRequestMethod("POST");   //设置POST方式连接
        //设置请求属性
        httpConn.setRequestProperty("token",Token);
//        httpConn.setRequestProperty("Connection", "Keep-Alive");// 维持长连接
        httpConn.setRequestProperty("Charset", "UTF-8");
        //连接,也可以不用明文connect，使用下面的httpConn.getOutputStream()会自动connect
//        httpConn.connect();
        //建立输入流，向指向的URL传入参数
        DataOutputStream dos = new DataOutputStream(httpConn.getOutputStream());
        dos.writeBytes(param);
        dos.flush();
        dos.close();
        if (HttpURLConnection.HTTP_OK == httpConn.getResponseCode()) {
            StringBuffer sb = new StringBuffer();
            String readLine = new String();
            BufferedReader responseReader = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));

            while((readLine=responseReader.readLine())!=null){
                sb.append(readLine).append("\n");
            }
            responseReader.close();
            return sb.toString();
        }
        return "请求失败";


    }
}