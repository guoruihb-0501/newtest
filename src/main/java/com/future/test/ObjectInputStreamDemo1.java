package com.future.test;

import java.io.FileInputStream;
import java.io.ObjectInputStream;

/**
 * @author guorui
 * @create 2022-06-06-21:37
 */
public class ObjectInputStreamDemo1 {
    public static void main(String[] args) throws  Exception {
        ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("E://SerializedStudent.obj"));
        SerializedStudent s = (SerializedStudent) ois1.readObject();
        System.out.println(s);
    }
}
