package com.future.test;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author guorui
 * @create 2022-06-10-15:39
 */
public class InetAddressDemo1 {
    public static void main(String[] args) throws Exception {
        InetAddress ip1 = InetAddress.getLocalHost();
        System.out.println(ip1.getHostAddress());
        System.out.println(ip1.getHostName());

        InetAddress ip2 = InetAddress.getByName("www.baidu.com");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

        InetAddress ip3 = InetAddress.getByName("220.181.38.150");
        System.out.println(ip2.getHostAddress());
        System.out.println(ip2.getHostName());

        System.out.println(ip3.isReachable(5000));  //在5秒内判断一个地址的连通性，返回boolean
    }
}
