package com.future.test;

import org.apache.commons.io.FileUtils;
import org.apache.commons.io.IOUtils;

import java.io.*;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.util.List;

/**
 * @author guorui
 * @create 2022-06-07-17:52
 */
public class CommonsIODemo1 {
    public static void main(String[] args) throws Exception {
        //复制文件
//        int b = IOUtils.copy(new FileInputStream("d:\\future\\frcds_bg\\ftframe.pbd"),
//                new FileOutputStream("d:\\future\\frcds_bg\\ftframe2.pbd"));
//        //返回复制的文件大小，所以如果要复制4G以上的文件，建议使用copyLarge，返回long
//        long a = IOUtils.copyLarge(new FileInputStream("g:\\迅雷下载\\CentOS-7-x86_64-DVD-1810.iso"),
//                new FileOutputStream("g:\\迅雷下载\\CentOS-7-x86_64-DVD-18102.iso"));
//        System.out.println(a);
//        System.out.println(b);
//        //复制文件到文件夹
//        FileUtils.copyFileToDirectory(new File("d:\\future\\frcds_bg\\ftframe.pbd"),new File("d:\\future2"));
          //FileUtils.moveFileToDirectory(new File("d:\\future\\frcds_bg\\ftframe.pbd"), new File("d:\\future2"), true);
//
// 复制文件夹到文件夹 目标文件夹不存在则创建，存在则合并而不是复写
//        FileUtils.copyDirectoryToDirectory(new File("D:\\future2"),new File("D:\\future3"));
//          FileUtils.moveDirectory(new File("D:\\future2"),new File("D:\\future3"));
//          FileUtils.forceMkdir(new File("D:\\future4\\future4\\future4\\future4")); // 创建文件夹(可创建多级)
//          //从文件名称获取输入流
//          FileUtils.openInputStream(new File("d:\\future\\frcds_bg\\ftframe.pbd"));
          //将文件变为字符串集合
//        List<String> list = FileUtils.readLines(new File("./src/新建文本文档b.txt"), "GBK"); // 把文件读取成字符串集合
        //        FileUtils.deleteDirectory(new File("D:\\future3"));
//        FileUtils.delete(new File("D:\\future2\\ftframe.pbd"));i
        // 通过文本获取输入流 ， 可以指定编码格式
//        InputStream is = IOUtils.toInputStream("你好 java", "GBK");
//        BufferedInputStream bis = IOUtils.buffer(is);
//        String s1 = IOUtils.toString(is, "GBK");
//        System.out.println(s1);
//        String s2 =IOUtils.toString( new URL("https://blog.csdn.net/backbug/article/details/99572931"));
//        String s3 =IOUtils.toString( new FileInputStream("./src/新建文本文档b.txt"),"GBK");
//
//        System.out.println(s2);
//        System.out.println(s3);
//        byte[] arr1 = IOUtils.toByteArray(is);

        // 把字符串写入文件
//        FileUtils.writeStringToFile(new File("./src/新建文本文档b.txt"), "测试", "GBK",true);
//        FileUtils.writeByteArrayToFile(new File("./src/新建文本文档b.txt"), arr1,true);

//        List<File> filelist = (List<File>) FileUtils.listFiles(new File("D:\\future"),null,true);
//        filelist.stream().forEach(file -> System.out.println(file.getAbsolutePath()));
        //System.out.println(FileUtils.directoryContains(new File("D:\\"), new File("D:\\log4j.log")));
        //FileUtils.copyURLToFile(new URL("https://cdn.iciba.com/www/top/logo.png"), new File("D:\\future\\logogr.png")) ;
//        String s1 = FileUtils.readFileToString(new File("./src/新建文本文档b.txt"), "GBK");
//        System.out.println(s1);

        String s1 = IOUtils.toString(new FileInputStream("./src/新建文本文档b.txt"), "GBK");
        System.out.println(s1);
    }
}
