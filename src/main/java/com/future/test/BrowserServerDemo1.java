package com.future.test;

import java.io.*;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.*;

/**
 * @author guorui
 * @create 2022-06-11-10:35
 */
public class BrowserServerDemo1 {
    //定义线程池
    private static ExecutorService pool = new ThreadPoolExecutor(3,5,2,
            TimeUnit.HOURS,new ArrayBlockingQueue<>(5),
            Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());
    public static void main(String[] args) throws Exception {
        //开放自身服务器的8080端口供客户端浏览器访问
        ServerSocket serverSocket = new ServerSocket(8080);
        while (true) {
            Socket socket = serverSocket.accept();
            pool.execute(new ServerReaderRunnable3(socket));
        }
    }
}

class ServerReaderRunnable3 implements Runnable{
    //接收socket
    private Socket socket;
    public ServerReaderRunnable3(Socket socket){
        this.socket = socket;
    }
    @Override
    public void run() {  //run方法不能抛异常，所以要在下面的语句 try catch
        try {
            //浏览器已经和本线程进行了连接，在此显示消息给浏览器
            PrintStream ps = new PrintStream(socket.getOutputStream());
            //按浏览器能够接收的格式发送数据
            ps.println("HTTP 1.1 200 ok");
            ps.println("Content-Type:text/html;charset=UTF-8");
            ps.println();
            ps.println("<span style='color:red;font-size:24px'> 服务器输出 </span>");
            ps.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}