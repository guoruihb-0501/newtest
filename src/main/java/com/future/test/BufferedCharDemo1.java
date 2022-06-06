package com.future.test;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

/**
 * @author guorui
 * @create 2022-06-06-10:13
 */
public class BufferedCharDemo1 {
    public static void main(String[] args) throws Exception {

        try (
                Reader fr1 = new FileReader("./src/新建文本文档3.txt");
                BufferedReader br1 = new BufferedReader(fr1);
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
