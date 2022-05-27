package com.future.test;

import java.lang.reflect.Field;

/**
 * @author guorui
 * @create 2022-05-02-11:50
 */
public class Mybatisutil {
    public static void print(Object obj){   //传入任意对象，通过反射获得信息
        //获取传入的任意对象的类对象
        Class c = obj.getClass();
        // c.getSimpleName()获取类的简单名字，例如Student
        // c.getName()获取类的全限名 com.future.imparial.court.entity.Student
        System.out.println("===========" + c.getSimpleName() + "===========");
        //获取该类对象的所有成员变量
        Field[] fields = c.getDeclaredFields();
        for (Field field : fields) {
            try {
                //获得每个成员变量的变量名
                String name = field.getName();
                //成员变量可能是private修饰的，在此突破限制强制提升权限为public
                field.setAccessible(true);
                //获得传入的每个成员变量的值，字符串存储
                String value = field.get(obj) + "";
                //输出打印结果
                System.out.println(name + "=" + value);
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
}
