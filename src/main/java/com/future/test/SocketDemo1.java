package com.future.test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;

/**
 * @author guorui
 * @create 2022-06-10-21:48
 */
public class SocketDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        Socket socket = new Socket("127.0.0.1",7777);
        //将socket的输出流与IO流对象绑定
        OutputStream os = socket.getOutputStream();
        //将原始IO流包装成高级流，打印流PrintStream
        PrintStream ps = new PrintStream(os);
        //服务器要读完整一行内容，所以要使用ps.println而不是ps.print
        ps.println("TCP客户端输出流测试");
        ps.close();
        //客户端一旦发送完信息程序运行完毕，socket也会自动失效
        //客户端一旦失效，因为是TCP连接，那么服务器端的socket也会同时失效而退出

        //socket.close();  //一般客户退出时关闭资源，不建议每次发出内容都关闭socket，建立socket比较消耗资源
    }
}
