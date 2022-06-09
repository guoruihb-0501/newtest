package com.future.test;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.Properties;

/**
 * @author guorui
 * @create 2022-06-07-17:27
 */
public class PropertiesDemo1 {
    public static void main(String[] args) throws Exception {
        //Properties是Map类的子类
        Properties p1 = new Properties();
        //不建议使用put，而是使用Properties特有的方法
        //p.put("admin","123456");
        //p.put("张三","男");
        p1.setProperty("admin","123456");
        p1.setProperty("张三","男");
        p1.store(new FileWriter("./src/password.properties"),"comment");

//        #comment
//        #Tue Jun 07 17:33:40 CST 2022
//        张三=男
//        admin=123456
        Properties p2 = new Properties();
        p1.load(new FileReader("./src/password.properties"));
        String s1 = p1.getProperty("admin");
        String s2 = p1.getProperty("张三");
        System.out.println(s1);
        System.out.println(s2);

    }
}
