package com.future.test;

/**
 * @author guorui
 * @create 2022-06-08-21:26
 */
public class RunnableDemo1 {
    public static void main(String[] args) {
        Thread t1 = new Thread(new MyRunnable());
        t1.start();
        for(int x=0; x<60; x++)
            System.out.println("主线程 run----"+x);
    }
}

class MyRunnable implements Runnable{

    @Override
    public void run()
    {
        for(int x=0; x<60; x++)
            System.out.println("子线程 run----"+x);   //run方法的作用就是承载多线程需要运行的代码。
    }
}
