package com.future.test;

/**
 * @author guorui
 * @create 2022-05-02-9:59
 */
public class Zi extends Fu{
    int num;
    Zi()
    {
        //super();
        // 即使不显式调用，系统也会自动运行父类的构造函数
        num = 30;
        System.out.println("zi run");
    }
    void speak()
    {
        System.out.println("java");
    }
}
