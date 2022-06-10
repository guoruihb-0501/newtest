package com.future.test;

import java.util.Date;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @author guorui
 * @create 2022-06-10-10:55
 */
public class ScheduledExecutorServiceDemo1 {
    public static void main(String[] args) {
        ScheduledExecutorService pool = Executors.newScheduledThreadPool(3);
        //定时执行打印任务，1秒后开始执行，每3秒执行1次
        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...run...A" + new Date());
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
             }
        },1,3, TimeUnit.SECONDS);

        pool.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...run...B" + new Date());
                System.out.println(10/0);
            }
        },1,3, TimeUnit.SECONDS);
    }
}
