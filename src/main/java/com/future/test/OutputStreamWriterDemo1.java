package com.future.test;

import java.io.*;

/**
 * @author guorui
 * @create 2022-06-06-20:30
 */
public class OutputStreamWriterDemo1  {
    public static void main(String[]args) throws Exception{
        try (
                OutputStream os1 = new FileOutputStream("E:/222.txt");
                Writer fw1 = new OutputStreamWriter(os1,"GBK");
                BufferedWriter bw1 = new BufferedWriter(fw1);
        ){

            bw1.write("我是中国人1");
            bw1.write("我是中国人2");
            bw1.write("我是中国人3");
            bw1.newLine();
            bw1.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
