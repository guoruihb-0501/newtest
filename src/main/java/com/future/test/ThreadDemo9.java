package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-14:51
 */
public class ThreadDemo9 {
    public static void main(String[] args) {
        //创建账户对象
        Account5 acc1 = new Account5("ICBC-001",100000);
        //两个线程共享同一个账户对象
        //小红和小明共享acc账户
        Thread t1 = new DrawThread5(acc1,"小红取钱");
        Thread t2 = new DrawThread5(acc1,"小明取钱");
        t1.start();
        t2.start();
        Thread t3 = new DepositThread5(acc1,"亲爹存钱");
        Thread t4 = new DepositThread5(acc1,"干爹存钱");
        Thread t5 = new DepositThread5(acc1,"岳父存钱");
        t3.start();
        t4.start();
        t5.start();
    }
}

class DrawThread5 extends Thread{
    //接收处理的账户对象
    private Account5 acc;
    //创建构造函数
    public DrawThread5(Account5 acc,String name){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run(){
        while (true){
            acc.drawMoney(100000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}

class DepositThread5 extends Thread{
    //接收处理的账户对象
    private Account5 acc;
    //创建构造函数
    public DepositThread5(Account5 acc,String name){
        super(name);
        this.acc = acc;
    }
    @Override
    public void run(){
        while (true){
            acc.depositMoney(100000);
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

    }
}