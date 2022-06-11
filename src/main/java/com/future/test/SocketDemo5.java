package com.future.test;

import java.io.*;
import java.io.InputStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @author guorui
 * @create 2022-06-11-9:26
 */
public class SocketDemo5 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        Socket socket = new Socket("127.0.0.1", 7777);

        //客户端不但要发消息，还要接收服务器端转发的消息
        new ClientReaderThread(socket).start();
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

class ClientReaderThread extends Thread{
    private Socket socket;
    public ClientReaderThread(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {  //run方法不能抛异常，所以要在下面的语句 try catch
        try {
            //将socket的输入流与IO流对象绑定
            InputStream is = socket.getInputStream();
            //将原始IO流包装为高级缓冲字符输入流（需要通过转换流InputStreamReader转换）
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            String msg;
            while ((msg = br.readLine()) != null){
                //打印输出服务器端发来的消息
                System.out.println("服务器端发来消息：" + msg);
            }
        } catch (Exception e) {
            //异常处理，服务器端连接断开，进行监控返回给客户端控制台
            System.out.println("服务器端把你踢出去了");
        }
    }

}