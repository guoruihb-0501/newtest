package com.future.test;

import java.io.*;
import java.io.InputStream;

/**
 * @author guorui
 * @create 2022-06-06-20:14
 */
public class InputStreamReaderDemo1 {
    public static void main(String[] args) throws Exception {
        try (
                InputStream is1 = new FileInputStream("E:/111.txt");
                Reader rs1 = new InputStreamReader(is1,"GBK");
                BufferedReader br1 = new BufferedReader(rs1);
                                                              ){
            String line;
            while ((line = br1.readLine()) != null){
                System.out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
