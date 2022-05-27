package com.future.test;

/**
 * @author guorui
 * @create 2022-05-11-14:32
 */
public class FactoryDemo {
    public static void main(String[] args) {
        //传统创建对象方式
        //Computer c1 = new Mac();
        //c1.setName("Mac");
        //c1.setPrice(9999);
        //c1.start();
        //Computer c2 = new Dell();
        //c2.setName("Dell");
        //c2.setPrice(8888);
        //c2.start();

        //使用工厂模式创建对象
        Computer c1 = FactoryPattern.createComputer("mac");
        Computer c2 = FactoryPattern.createComputer("dell");
        c1.start();
        c2.start();
    }
}
