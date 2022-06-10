package com.future.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author guorui
 * @create 2022-06-10-15:58
 */
public class DatagramPacketDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        //创建接收端对象，接收端使用8888端口接收发送端数据，创建之后只要没有接收到数据就处于阻塞状态
        DatagramSocket ds2 = new DatagramSocket(8888);
        //创建接收端数据包对象
        //接收内容到本机的8888端口
        byte[] bytes = new byte[1024 *64];  //一个udp数据包最大是64k，所以创建一个足够大的字节数组保证完整接受数据
        DatagramPacket dp2 = new DatagramPacket(bytes,bytes.length);
        ds2.receive(dp2);
        //获取接收到的数据包长度
        int len = dp2.getLength();
        System.out.println(len);
        //因为bytes的长度是64k，所以如果不截取，会得到一个固定64k长度的信息
        String rs = new String(bytes,0,len);
        System.out.println("收到了" + rs);
        //获取发送端的地址和端口
        System.out.println("发送端地址" + dp2.getAddress().toString());
        System.out.println("发送端端口" + dp2.getPort());

        ds2.close();
    }
}
