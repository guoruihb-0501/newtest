package com.future.test;

import java.io.*;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author guorui
 * @create 2022-06-11-9:27
 */
public class ServerSocketDemo5 {
    //将全部连接存入一个List集合，以便进行转发
    public static List<Socket> allOnlineSocket = new ArrayList<>();
    //定义线程池
    private static ExecutorService pool = new ThreadPoolExecutor(3,5,2,
            TimeUnit.HOURS,new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    //各参数含义见 day12_线程间通信和线程池——2.2.通过runnable接口实现线程池

    public static void main(String[] args) throws Exception {
        System.out.println("服务器启动");
        //创建ServerSocket，并开放自己的7777端口
        ServerSocket serverSocket = new ServerSocket(7777);
        while (true) {
            //等待接收数据，如果没有收到消息则会阻塞等待
            //每接收一个socket，都要交给一个独立的子线程
            Socket socket = serverSocket.accept();
            //每接收一个socket，都要将其存入集合
            allOnlineSocket.add(socket);
            //监控客户端上线
            System.out.println(socket.getRemoteSocketAddress() + "上线了");
            //启动线程池接收socket
            Runnable target = new ServerReaderRunnable2(socket);
            pool.execute(target);
        }
    }
}

class ServerReaderRunnable2 implements Runnable{
    //接收socket
    private Socket socket;
    public ServerReaderRunnable2(Socket socket){
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
                //将信息转发给所有其他客户端
                sendMsg2All(msg);
            }
        } catch (Exception e) {
            //异常处理，对方连接断开，进行监控返回给服务器端控制台
            System.out.println(socket.getRemoteSocketAddress() + "下线了");
            //将客户端连接从集合中抹掉
            ServerSocketDemo5.allOnlineSocket.remove(socket);
        }
    }
    private void sendMsg2All(String msg) throws Exception {
        for (Socket socket : ServerSocketDemo5.allOnlineSocket) {
            PrintStream ps = new PrintStream(socket.getOutputStream());
            ps.println(msg);
            ps.flush();
        }
    }
}

