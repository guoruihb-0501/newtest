package com.future.test;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * @author guorui
 * @create 2022-06-06-10:29
 */
public class BufferedCharDemo2 {
    public static void main(String[] args) throws Exception {
        try (
                Writer fw1 = new FileWriter("./src/新建文本文档8.txt",true);
                BufferedWriter bw1 = new BufferedWriter(fw1);
                ){

            char[] buffer2 = "abc我是中国人".toCharArray();
            bw1.write(buffer2);
            //bw1.write("\r\n");
            bw1.newLine();
            bw1.write(buffer2,1,3);
            bw1.flush();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
