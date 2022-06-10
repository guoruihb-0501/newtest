package com.future.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author guorui
 * @create 2022-06-10-15:51
 */
public class DatagramPacketDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        //创建发送端对象，发送端一般不用指定端口号，服务端可以通过packet.getPort获得发送端的端口
        DatagramSocket ds1 = new DatagramSocket();
        //也可以指定端口如下
        //DatagramSocket ds1 = new DatagramSocket(6666);
        //要发送的数据
        byte[] bytes = "要发送的数据".getBytes();
        //创建发送端数据包对象  //发送内容到目标机的8888端口
        DatagramPacket dp1 = new DatagramPacket(bytes,bytes.length, InetAddress.getLocalHost(),8888);
        ds1.send(dp1);
        ds1.close();
    }
}
