package com.future.test;

import java.util.concurrent.Callable;

/**
 * @author guorui
 * @create 2022-06-09-21:05
 */
class CallableDemo2 implements Callable<String> {
    private int n;

    public CallableDemo2(int n) {
        this.n = n;
    }
    @Override
    public String call() throws Exception {
        //重写call方法，求1-n之和，将结果返回
        int sum = 0;
        for (int i=0;i<=n;i++){
            sum = sum + i;
        }
        return Thread.currentThread().getName() + "执行1到" + n + "的和 = " + sum;
    }
}
