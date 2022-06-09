package com.future.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author guorui
 * @create 2022-06-02-15:03
 */
public class FileWriterDemo1 {
    public static void main(String[] args) throws Exception {
        //1.逐个字符写入文件
        //FileWriter fw1 = new FileWriter("./src/新建文本文档7.txt");
        //如果不希望每次复写文件，而是将新内容增加到原来文件结尾可以用下面的语句
        FileWriter fw1 = new FileWriter("./src/新建文本文档7.txt",true);
        fw1.write(98);
        fw1.write('K');
        fw1.write('好');
        fw1.write("\r\n");
        fw1.flush();
        fw1.write("我是中国人");
        fw1.close();

        //2.字符数组写入文件
        FileWriter fw2 = new FileWriter("./src/新建文本文档8.txt",true);
        char[] buffer2 = "abc我是中国人".toCharArray();
        fw2.write(buffer2);
        fw2.write("\r\n");
        fw2.write(buffer2,1,3);
        fw2.flush();
        fw2.close();

    }
}
