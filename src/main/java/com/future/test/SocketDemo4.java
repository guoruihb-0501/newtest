package com.future.test;

import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author guorui
 * @create 2022-06-11-8:39
 */
public class SocketDemo4 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        Socket socket = new Socket("127.0.0.1",7777);
        //将socket的输出流与IO流对象绑定
        OutputStream os = socket.getOutputStream();
        //将原始IO流包装成高级流，打印流PrintStream
        PrintStream ps = new PrintStream(os);
        //服务器要读完整一行内容，所以要使用ps.println而不是ps.print
        Scanner sc = new Scanner(System.in);
        while (true) {
            //通过键盘录入发送消息
            System.out.println("请说：");
            String msg = sc.nextLine();
            ps.println(msg);
            ps.flush();
        }
    }
}
