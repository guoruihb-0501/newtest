package com.future.test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @author guorui
 * @create 2022-06-02-9:00
 */
public class FileOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //1.逐个字节写入字节输出流
        //默认情况下重复运行程序会复写本文件，而不是在原文件之后附加
        //如果希望附加 应该这样定义字节输出流  FileOutputStream fos1 = new FileOutputStream("./src/新建文本文档4.txt",true);
        FileOutputStream fos1 = new FileOutputStream("./src/新建文本文档4.txt");

        fos1.write('a');  //写入1个字节
        fos1.write(66);   //通过ascii编码写入1个字节
        //fos1.write('中');  //写入中文内容会产生乱码，因为中文要占2-3个字节
        //把缓存中的数据刷新到文件,将缓存内数据刷新到文件之后，要关闭字节输出流，释放资源
        fos1.flush();
        //刷新之后流仍然可以继续使用
        fos1.write('c');
        //fos1.close();方法本身包含了一次刷新，会在释放资源之前自动刷新一次
        fos1.close();

        //2.通过字节数组写入字节输出流
        FileOutputStream fos2 = new FileOutputStream("./src/新建文本文档5.txt",true);
        //生成字节数组
        byte[] buffer2a = {'b',67,'d',69,70};
        fos2.write(buffer2a);
        //写入换行信息
        fos2.write("\r\n".getBytes());
        //将字符串转换成字节数组
        byte[] buffer2b = "中国".getBytes(); //可以指定字符集，默认为UTF-8
        fos2.write(buffer2b);
        //写入换行信息
        fos2.write("\r\n".getBytes());
        fos2.flush();
        byte[] buffer2c = {'c',68,'e',70,71};
        fos2.write(buffer2c);
        //写入换行信息
        fos2.write("\r\n".getBytes());
        fos2.close();

        //3.将字节数组的一部分写入字节输出流
        FileOutputStream fos3 = new FileOutputStream("./src/新建文本文档6.txt");
        //生成字节数组
        byte[] buffer3 = {'b',67,'d',69,70};
        fos3.write(buffer3,2,2);  //写入 'd',69
        fos3.write("\r\n".getBytes());
        fos3.close();

    }
}
