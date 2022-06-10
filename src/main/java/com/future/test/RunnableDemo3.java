package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-20:52
 */
public class RunnableDemo3 implements Runnable{

    @Override
    public void run() {
        for (int i=1;i<=5;i++){
            System.out.println(Thread.currentThread().getName() + "...run..." + i);
        }
        try {
            System.out.println(Thread.currentThread().getName() + "本线程进入休眠");
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
