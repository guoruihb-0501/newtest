package com.future.test;

import java.io.FileNotFoundException;
import java.io.FileReader;

/**
 * @author guorui
 * @create 2022-06-02-15:03
 */
public class FileReaderDemo1 {
    public static void main(String[] args) throws Exception {
        //1.逐个字符读取文件
        //比字节流好在不会把1个中文字符（占2-3个字节）切分字节造成乱码
        FileReader fr1 = new FileReader("./src/新建文本文档3.txt");

        //逐个字符读取文件
        int code1;
        while ((code1 = fr1.read()) != -1){
            System.out.print((char) code1);
        }
        System.out.println("");
        System.out.println("------分割线1------");
        //2.按字符数组读取文件
        FileReader fr2 = new FileReader("./src/新建文本文档3.txt");
        char[] buffer2 = new char[1024];
        int len;
        while ((len = fr2.read(buffer2)) != -1){
            String rs = new String(buffer2,0,len);
            System.out.print(rs);
        }
        System.out.println("");
        System.out.println("------分割线2------");

    }
}
