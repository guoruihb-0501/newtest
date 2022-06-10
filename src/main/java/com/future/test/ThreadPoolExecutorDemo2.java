package com.future.test;

import java.util.concurrent.*;

/**
 * @author guorui
 * @create 2022-06-09-21:08
 */
public class ThreadPoolExecutorDemo2 {
    public static void main(String[] args) throws Exception {
        ExecutorService pool = new ThreadPoolExecutor(3, 5, 2,
                TimeUnit.HOURS, new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(), new ThreadPoolExecutor.AbortPolicy());
        Future<String> f1 = pool.submit(new CallableDemo2(100));
        Future<String> f2 = pool.submit(new CallableDemo2(200));
        Future<String> f3 = pool.submit(new CallableDemo2(300));
        Future<String> f4 = pool.submit(new CallableDemo2(400));
        Future<String> f5 = pool.submit(new CallableDemo2(400));

        System.out.println(f1.get());
        System.out.println(f2.get());
        System.out.println(f3.get());
        System.out.println(f4.get());
        System.out.println(f5.get());
    }
}
