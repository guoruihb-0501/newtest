package com.future.test;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * @author guorui
 * @create 2022-06-10-16:35
 */
public class DatagramPacketDemo3 {
    public static void main(String[] args) throws Exception {
        System.out.println("客户端启动");
        DatagramSocket ds3 = new DatagramSocket(7777);
        BufferedReader bufr =
                new BufferedReader(new InputStreamReader(System.in));     //通过键盘录入的方式进行发送内容
        String line = null;
        while((line=bufr.readLine())!=null)          //阻塞式方法，等待录入
        {
            if("exit".equals(line)) {       //当发送886的时候断开
                System.out.println("发送结束");
                ds3.close();
                break;
            }
            byte[] buf = line.getBytes();   //获取录入的内容变成字符数组，然后封包成udp数据包
            DatagramPacket dp3 =
                    new DatagramPacket(buf,buf.length, InetAddress.getLocalHost(),8888);

            ds3.send(dp3);
        }

    }
}
