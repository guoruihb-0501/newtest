package com.future.test;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author guorui
 * @create 2022-06-10-10:17
 */
public class ExecutorsDemo1 {
    public static void main(String[] args) {
        //newFixedThreadPool 会同时设定核心线程数量和最大线程数量
        //核心线程数量=最大线程数量，也就是没有临时线程，但可以加入队列，方法没有对队列数量进行限制
        //根据继承关系可以看到，Executors类底层依然依靠ThreadPoolExecutor类实现，只是会固定了核心线程量，或最大线程量。
        ExecutorService pool = Executors.newFixedThreadPool(4);

        //达到最大线程数量4
        pool.execute(new RunnableDemo4());
        pool.execute(new RunnableDemo4());
        pool.execute(new RunnableDemo4());
        pool.execute(new RunnableDemo4());
        //超过最大线程数量进入队列，因为没有对队列数量进行限制
        //意味着大量线程进来之后可能会导致内存溢出，大型系统一般不用
        //Executors的几个工具方法都没有限制队列数量，优点是代码简单，缺点是有一定风险
        pool.execute(new RunnableDemo4());
        pool.execute(new RunnableDemo4());
    }
}
