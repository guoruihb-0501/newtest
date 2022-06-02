package com.future.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

/**
 * @author guorui
 * @create 2022-06-01-20:41
 */
public class FileInputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        //2.1.低性能_逐个字节读取数据
//       逐个字节读取是无法读取中文内容的，中文通常占2-3个字节
        FileInputStream fis1 = new FileInputStream("./src/新建文本文档.txt");
        int b;
        /*      不能写 while (fis.read != -1) 因为流只能用1次，下面的语句还要打印，如果直接用流，下面就无法打印了，所以需要先把流存成一个变量b，然后下面打印变量b  */
        while ((b = fis1.read()) != -1){
            System.out.print((char)b);
        }
        System.out.println("");
        System.out.println("-----------分割线1-----------");
        //2.2.通过字节数组读取数据
        FileInputStream fis2 = new FileInputStream("./src/新建文本文档2.txt");
        byte[] buffer2 = new byte[3];
        int len2;
        while ((len2 = fis2.read(buffer2)) != -1){
/*           下面语句中new String(buffer,0,len) 用来读取字节数组指定开始位置0到指定截止位置len
              这个例子字符数组长度=3，但文件内容不一定能被3整除，所以在文件结尾的时候假如还剩2个字节，但字节数组长度固定=3，所以就会把上个字节数组的最后一位余留下来
              而加上这个开始和截止位置，可以做到最后一个字节数组只读前2个字节，而不再读上个字节数组留下的第3位
              这种方式仍然不适合读中文，每个中文加入是3个字节，但是文件内容加入是ab我爱你，当读完ab之后，字节数组还剩1位，就会继续读我这个汉字的第1个字节，最后导致乱码  */
            System.out.print(new String(buffer2,0,len2));
        }
        System.out.println("");
        System.out.println("-----------分割线2-----------");
        //2.3.一次把整个文件读完放在一个数组
//      这样就可以保证不会截断中文
        String filename = "./src/新建文本文档3.txt";
        FileInputStream fis3 = new FileInputStream(filename);
        File f = new File(filename);
        long len3 = f.length();
//定义一个和文件长度一样大的字节数组，一次将文件读入字节数组
        byte[] buffer3 = new byte[(int)len3];
        fis3.read(buffer3);
        System.out.println(new String(buffer3));

        System.out.println("-----------分割线3-----------");
    }
}
