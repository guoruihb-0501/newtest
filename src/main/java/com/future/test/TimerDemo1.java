package com.future.test;

import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * @author guorui
 * @create 2022-06-10-10:37
 */
public class TimerDemo1 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //定时执行打印任务，1秒后开始执行，每2秒执行1次
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...run...A" + new Date());
                //虽然B任务是在1秒钟之后开始，但是A计划需要等5秒，那么B计划也必须要跟着A计划等5秒
                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        },1000,2000);


        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "...run...B" + new Date());
                //B计划执行异常，会影响A计划的运行
                System.out.println(10/0);
            }
        },1000,2000);
    }
}
