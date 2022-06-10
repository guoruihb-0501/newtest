package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-14:51
 */
public class ThreadDemo6 {
    public static void main(String[] args) {
        //创建账户对象
        Account2 acc1 = new Account2("ICBC-001",100000);
        //两个线程共享同一个账户对象
        //小红和小明共享acc账户
        Thread t1 = new DrawThread2(acc1,"小红取钱");
        Thread t2 = new DrawThread2(acc1,"小明取钱");
        t1.start();
        t2.start();

        //创建账户对象
        Account2 acc2 = new Account2("ICBC-002",100000);
        //两个线程共享同一个账户对象
        //张三和李四共享acc2账户
        Thread t3 = new DrawThread2(acc2,"张三取钱");
        Thread t4 = new DrawThread2(acc2,"李四取钱");
        t3.start();
        t4.start();
    }
}

class DrawThread2 extends Thread{
    //接收处理的账户对象
    private Account2 acc;
    //创建构造函数
    public DrawThread2(Account2 acc,String name){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run(){
        acc.drawMoney(100000);
    }
}
