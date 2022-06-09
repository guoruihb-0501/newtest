package com.future.test;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

/**
 * @author guorui
 * @create 2022-06-06-21:33
 */
public class ObjectOutputStreamDemo1 {
    public static void main(String[] args) throws Exception {
        SerializedStudent s = new SerializedStudent("王五",'女',11,"六年级3班","睡觉");
        ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("E:/SerializedStudent.obj"));
        oos1.writeObject(s);
        oos1.close();
    }
}
