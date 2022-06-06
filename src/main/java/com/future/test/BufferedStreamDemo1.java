package com.future.test;

import java.io.*;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;

/**
 * @author guorui
 * @create 2022-06-06-9:28
 */
public class BufferedStreamDemo1 {
    public static void main(String[] args) throws Exception {
        long StartTime = System.currentTimeMillis();
        try (
                InputStream is1 = new FileInputStream("./src/1.iso");
                OutputStream os1 = new FileOutputStream("./src/2.iso");
                BufferedInputStream bis1 = new BufferedInputStream(is1);
                BufferedOutputStream bos1 = new BufferedOutputStream(os1);) {

            byte[] buffer1 = new byte[8192];
            int len;

            while ((len = bis1.read(buffer1)) != -1){
                bos1.write(buffer1,0,len);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("复制完成");
        long EndTime = System.currentTimeMillis();
        System.out.println("复制的时间为：" + (EndTime - StartTime)/1000.0 + "秒");
    }
}

