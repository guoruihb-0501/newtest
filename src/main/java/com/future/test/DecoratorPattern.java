package com.future.test;

public class DecoratorPattern {
    public static void main(String[] args) {
        //给装饰类传入原始类对象，这样在不改变原始类的功能的情况下还可以扩充功能
        InputStream is = new BufferedInputStream(new FileInputStream());
        System.out.println(is.read());
        System.out.println(is.read(new byte[3]));
    }
}
