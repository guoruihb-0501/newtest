package com.future.test;

/**
 * @author guorui
 * @create 2022-06-08-21:49
 */
public class RunnableDemo2 {
    public static void main(String[] args) {
//        //通过匿名内部类创建Runnable对象
//        Runnable target = new Runnable() {
//            @Override
//            public void run() {
//                for(int x=0; x<60; x++)
//                    System.out.println("子线程 run----"+x);
//            }
//        };
//        //把Runnable对象交给一个Thread线程
//        Thread t1 = new Thread(target);
//        //调用Thread线程的start方法启动线程
//        t1.start();
        //以上部分简写成如下格式
        new Thread(new Runnable() {
            @Override
            public void run() {
                for(int x=0; x<60; x++)
                    System.out.println("子线程1 run----"+x);
            }
        }).start();

        //进一步通过Lambda表达式简化如下
        new Thread(() -> {
                for(int x=0; x<60; x++)
                    System.out.println("子线程2 run----"+x);
        }).start();

        //创建主线程循环
        for(int x=0; x<60; x++)
            System.out.println("主线程 run----"+x);
    }
}
