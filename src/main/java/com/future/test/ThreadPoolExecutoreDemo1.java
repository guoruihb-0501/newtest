package com.future.test;

import java.util.concurrent.*;

/**
 * @author guorui
 * @create 2022-06-09-20:38
 */
public class ThreadPoolExecutoreDemo1 {
    public static void main(String[] args) {
        ExecutorService pool = new ThreadPoolExecutor(3,5,2,
                TimeUnit.HOURS,new ArrayBlockingQueue<>(5),
                Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        Runnable target = new RunnableDemo3();
        //3个核心线程
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        //5个队列线程
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        pool.execute(target);
        //临时线程
        pool.execute(target);
        pool.execute(target);
        //超出的线程
        pool.execute(target);

        //关闭线程池
//        pool.shutdownNow();  //立即关闭所有线程，即使任务未完毕
//        pool.shutdown();  //等线程任务完毕之后再关闭线程池
    }
}
