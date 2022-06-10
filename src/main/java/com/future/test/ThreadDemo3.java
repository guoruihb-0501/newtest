package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-10:49
 */
public class ThreadDemo3 {
    public static void main(String[] args)
    {
        Test3 t1 = new Test3();
        t1.setName("子线程1");
        Test3 t2 = new Test3();
        t2.setName("子线程2");
        t1.start();
        t2.start();

        Thread t = Thread.currentThread();
        t.setName("主线程");
        for(int x=0; x<60; x++)
        {
            System.out.println(t.getName() + "run..." + x);
        }
    }
}

class Test3 extends Thread{
    //private String name;
    @Override
    public void run()
    {
        for(int x=0; x<60; x++)
        {
            System.out.println(Thread.currentThread().getName()+" run..."+x);    //Thread-编号 该编号从0开始。
        }
    }
}