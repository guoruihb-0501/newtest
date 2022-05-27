package com.future.test;

import com.mysql.jdbc.PerVmServerConfigCacheFactory;

/**
 * @author guorui
 * @create 2022-05-12-9:14
 */
public class LambdaDemo1 {
    public static void main(String[] args) {

        //原型写法
//        App a = new App() {
//            @Override
//            public void run() {
//                System.out.println("start run");
//            }
//        };
        //Lambda表达式写法1
        App a1 = () -> {
            System.out.println("start run");
        };
        go(a1);
        //Lambda表达式写法2   //因为Lambda表达式只有一行代码，可以将{}和分号去掉
        App a2 = () -> System.out.println("start run");
        go(a2);

        System.out.println("------------------------");

        //原型写法
//        go(new App() {
//            @Override
//            public void run() {
//                System.out.println("start run");
//            }
//        });
        //Lambda表达式写法1
        go(() -> {
            System.out.println("start run");
        });
        //Lambda表达式写法2   //因为Lambda表达式只有一行代码，可以将{}和分号去掉
        go(() -> System.out.println("start run"));
    }

    public static void go(App app){
        System.out.println("run");
    }
}

//能做成lambda表达式的必须是接口，而且只有一个抽象方法的接口
//加上FunctionalInterface注解表示这个接口一定可以写成Lambda表达式，
// 如果没有加这个注解 但是一个只有一个抽象方法的接口 也可以做成Lambda表达式
@FunctionalInterface
interface App{
    void run();
}
