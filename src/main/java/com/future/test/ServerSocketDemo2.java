package com.future.test;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author guorui
 * @create 2022-06-10-22:34
 */
public class ServerSocketDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动");
        //创建ServerSocket，并开放自己的7777端口
        ServerSocket serverSocket = new ServerSocket(7777);
        //等待接收数据，如果没有收到消息则会阻塞等待
        Socket socket = serverSocket.accept();
        //将socket的输入流与IO流对象绑定
        InputStream is = socket.getInputStream();
        //将原始IO流包装为高级缓冲字符输入流（需要通过转换流InputStreamReader转换）
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        String msg;
        //因为服务器每次要读一行消息，所以客户端输出，必须要有换行符，使用ps.println而不是ps.print
        while ((msg = br.readLine()) != null){
        //while (br.readLine() != null) {
            //获取远程客户端地址，并打印输出客户端发来的消息
            System.out.println("客户端" + socket.getRemoteSocketAddress() + "发来消息：" + msg);
        }
    }
}
