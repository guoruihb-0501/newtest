package com.future.test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.io.PrintWriter;

/**
 * @author guorui
 * @create 2022-06-07-16:57
 */
public class PrintStreamDemo1 {
    public static void main(String[] args) throws Exception{
        //PrintStream ps = new PrintStream("./src/新建文本文档b.txt" );
        //默认是复写，如果需要使用append，需要使用FileOutputStream作为参数
        //PrintStream ps = new PrintStream("./src/新建文本文档b.txt" ,"GBK");
        PrintStream ps = new PrintStream(new FileOutputStream("./src/新建文本文档b.txt" ,true),true,"GBK");

        ps.print(97);
        ps.print(23.1);
        ps.println('a');
        ps.print('哈');
        ps.print("中国河北石家庄");
        ps.close();

        //PrintWriter pw = new PrintWriter("./src/新建文本文档b.txt" );
        PrintWriter pw = new PrintWriter(new FileOutputStream("./src/新建文本文档b.txt",true));
        pw.print(97);
        pw.print(23.1);
        pw.println('a');
        pw.print('哈');
        pw.print("中国河北石家庄");
        pw.close();

        PrintStream ps2 = new PrintStream("./src/新建文本文档d.txt" );
        System.setOut(ps2);
        System.out.println("abc");
    }
}
