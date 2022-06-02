package com.future.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * @author guorui
 * @create 2022-06-02-11:14
 */
public class CopyDemo1 {
    public static void main(String[] args) throws Exception {
        FileInputStream fis1 = null;
        FileOutputStream fos1 = null;
        try {
            fis1 = new FileInputStream("./src/logo.png");
            fos1 = new FileOutputStream("./src/logo2.png");
            byte[] buffer1 = new byte[4096];
            int len;

            while ((len = fis1.read(buffer1)) != -1){
                fos1.write(buffer1,0,len);
            }
            System.out.println("复制完成");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //因为finally代码块除非虚拟机直接退出否则都会运行，所以不要在这里写return，尤其是方法有输出参数的时候，这里写了return就会把所有代码块的return内容替换
            if (fos1 != null) {
                fos1.close();
            };
            if (fis1 != null) {
                fis1.close();
            }
        }
    }
}
