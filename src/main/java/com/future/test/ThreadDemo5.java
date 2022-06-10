package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-14:51
 */
public class ThreadDemo5 {
    public static void main(String[] args) {
        //创建账户对象
        Account1 acc = new Account1("ICBC-001",100000);
        //两个线程共享同一个账户对象
        Thread t1 = new DrawThread1(acc,"小红取钱");
        Thread t2 = new DrawThread1(acc,"小明取钱");
        t1.start();
        t2.start();
    }
}

class DrawThread1 extends Thread{
    //接收处理的账户对象
    private Account1 acc;
    //创建构造函数
    public DrawThread1(Account1 acc,String name){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run(){
        acc.drawMoney(100000);
    }
}
