package com.future.test;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author guorui
 * @create 2022-06-09-14:41
 */
public class Account4 {
    private String cardId;  //账户名称
    private double money;  //账户金额
    //创建对象锁，每个账户对象使用自己的锁，小红和小明使用同一把锁，张三和李四使用另一把锁
    //使用final修饰确保lock不会被人修改
    private final Lock lock = new ReentrantLock();

    public Account4() {
    }

    public Account4(String cardId, double money) {
        this.cardId = cardId;
        this.money = money;
    }

    @Override
    public String toString() {
        return "Account1{" +
                "cardId='" + cardId + '\'' +
                ", money=" + money +
                '}';
    }

    public void drawMoney(double money){
        //获取线程名称
        String name = Thread.currentThread().getName();
        //给账户上锁
        lock.lock();
        try {
            if (this.money >= money){
                System.out.println(name + "成功，本次取钱" + money + "元");
                //更新账户
                this.money = this.money - money;
                System.out.println(name + "后余额为" + this.money + "元");
            }else{
                System.out.println("余额不足");
            }
        } finally {
            //给账户解锁,确保在异常情况下账户也能被解锁，而不是被死锁住
            lock.unlock();
        }
    }

    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
