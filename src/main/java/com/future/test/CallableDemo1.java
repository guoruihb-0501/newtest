package com.future.test;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author guorui
 * @create 2022-06-08-22:08
 */
public class CallableDemo1 {
    public static void main(String[] args) {
        //创建Callable任务对象
        Callable<String> c1 = new MyCallable(100);
        FutureTask<String> f1 = new FutureTask<>(c1);
        //将任务对象交给Thread类，并启动start方法
        Thread t1 = new Thread(f1);
        t1.start();

        //创建Callable任务对象
        Callable<String> c2 = new MyCallable(200);
        //FutureTask是一个实现了Runnable接口的类，所以要把MyCallable对象通过FutureTask包装成实现Runnable接口的对象
        //然后再将FutureTask对象传给Thread，来实现多线程
        //同时FutureTask类有get方法，可以接收子线程返回结果，get方法可以保证必须子线程执行完毕之后才会去拿结果
        FutureTask<String> f2 = new FutureTask<>(c2);
        //将任务对象交给Thread类，并启动start方法
        Thread t2 = new Thread(f2);
        t2.start();

        //创建主线程循环
        for(int x=0; x<60; x++)
            System.out.println("主线程 run----"+x);

        try {
            //FutureTask的特性决定，t1线程没有完全跑完，f1.get()不会执行
            //同样t2线程没有完全跑完，f2.get()不会执行
            System.out.println(f1.get());
            System.out.println(f2.get());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}

class MyCallable implements Callable<String>{
    private int n;

    public MyCallable(int n) {
        this.n = n;
    }

    //重写call方法可以有返回值，本例返回值为String类型
    @Override
    public String call() throws Exception {
        //重写call方法，求1-n之和，将结果返回
        int sum = 0;
        for (int i=0;i<=n;i++){
            sum = sum + i;
        }
        return "sum = " + sum;
    }
}