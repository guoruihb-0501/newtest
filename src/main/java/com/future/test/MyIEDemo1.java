package com.future.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * @author guorui
 * @create 2022-06-11-10:54
 */
public class MyIEDemo1 {
    public static void main(String[] args)throws Exception
    {
        Socket s = new Socket("127.0.0.1",8080);   //访问tomcat服务器地址和端口
        PrintWriter out = new PrintWriter(s.getOutputStream(),true);
        out.println("GET /aa/a.html HTTP/1.1");       //发送HTTP头消息  /aa/a.html 为要访问的资源信息
        out.println("Accept: */*");
        out.println("Accept-Language: zh-cn");
        out.println("Host: 172.23.4.127:8080");     //访问上面例子中的服务器端
        out.println("Connection: closed");
        out.println();
        out.println();                                       //空行表示头消息结束标志  发送客户端的头消息后即可接收服务器的返回数据
        BufferedReader bufr = new BufferedReader(new InputStreamReader(s.getInputStream()));
        String line = null;
        while((line=bufr.readLine())!=null)
        {
            System.out.println(line);               //打印接收结果
            //如果访问的是真正的服务器端例如tomcat 则在看到结果之前还会看到服务器返回的http头
        }
        s.close();
    }
}
