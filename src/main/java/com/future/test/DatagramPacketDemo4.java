package com.future.test;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 * @author guorui
 * @create 2022-06-10-16:50
 */
public class DatagramPacketDemo4 {
    public static void main(String[] args) throws Exception {
        System.out.println("服务端启动");
        //创建接收端对象，接收端使用8888端口接收发送端数据，创建之后只要没有接收到数据就处于阻塞状态
        DatagramSocket ds4 = new DatagramSocket(8888);
        //创建接收端数据包对象
        //接收内容到本机的8888端口
        byte[] bytes = new byte[1024 *64];  //一个udp数据包最大是64k，所以创建一个足够大的字节数组保证完整接受数据
        DatagramPacket dp4 = new DatagramPacket(bytes,bytes.length);

        while (true){
            ds4.receive(dp4);
            //获取接收到的数据包长度
            int len = dp4.getLength();
            //因为bytes的长度是64k，所以如果不截取，会得到一个固定64k长度的信息
            String rs = new String(bytes,0,len);
            System.out.println("收到了来自发送端" + dp4.getAddress().toString() + "端口号" + dp4.getPort() + "的消息：" + rs);
        }
    }
}
