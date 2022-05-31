package com.future.test;


/**
 * @author guorui
 * @create 2022-05-19-16:47
 */
public class InnerClassAnonymous2 {
    public static void main(String[] args) {
        Swimming s = new Swimming() {  //匿名内部类
            @Override
            public void swim() {
                System.out.println("我要游泳");
            }
        };

        Swimming s2 = () ->  System.out.println("我要游泳 Lambda");    //匿名内部类的Lambda表达式写法

        goSwimming(s);
        goSwimming(s2);

        //匿名内部类还可以写成如下的形式
        goSwimming(new Swimming() {
            @Override
            public void swim() {
                System.out.println("我要游泳");
            }
        });
    }

    public static void goSwimming(Swimming swimming){
        System.out.println("开始游泳");
        swimming.swim();
        System.out.println("结束游泳");
    }
}

interface Swimming{
    void swim();
}
