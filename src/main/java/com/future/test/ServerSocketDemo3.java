package com.future.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author guorui
 * @create 2022-06-11-7:46
 */
public class ServerSocketDemo3 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动");
        //创建ServerSocket，并开放自己的7777端口
        ServerSocket serverSocket = new ServerSocket(7777);
        while (true) {
            //等待接收数据，如果没有收到消息则会阻塞等待
            //没接收一个socket，都要交给一个独立的子线程
            Socket socket = serverSocket.accept();
            //监控客户端上线
            System.out.println(socket.getRemoteSocketAddress() + "上线了");
            //启动线程接收socket
            new ServerReaderThread(socket).start();

        }
    }
}

class ServerReaderThread extends Thread{
    //接收socket
    private Socket socket;
    public ServerReaderThread(Socket socket){
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
            //因为服务器每次要读一行消息，所以客户端输出，必须要有换行符，使用ps.println而不是ps.print
            while ((msg = br.readLine()) != null){
                //获取远程客户端地址，并打印输出客户端发来的消息
                System.out.println("客户端" + socket.getRemoteSocketAddress() + "发来消息：" + msg);
            }
        } catch (Exception e) {
            //异常处理，对方连接断开，进行监控返回给服务器端控制台
            System.out.println(socket.getRemoteSocketAddress() + "下线了");
        }
    }
}
