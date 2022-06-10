package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-14:41
 */
public class Account2 {
    private String cardId;  //账户名称
    private double money;  //账户金额

    public Account2() {
    }

    public Account2(String cardId, double money) {
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
        //因为是ThreadDemo6文件的DrawThread2类通过acc.drawMoney调用
        //所以多个线程共享的对象就是acc，所以要为synchronized代码块传this，
        //保证所有线程共享的对象是acc账户对象
        //理论上synchronized代码块传任意唯一对象都可以，但是如果传和本线程无关的对象
        //会导致所有用户都会被同时锁住，即使不使用同一账户
        //应该小红和小明共享acc1账户，张三和李四共享acc2账户
        //如果传和本线程无关的对象，那么小红从acc1账户取钱的时候，不仅小明不能从acc1账户取钱，张三和李四也不能从acc2账户取钱
        //所以在此传this来表示各自的账户，小红或小明线程 this就是acc1账户，张三或李四线程 this就是acc2账户
        synchronized (this) {
            if (this.money >= money){
                System.out.println(name + "成功，本次取钱" + money + "元");
                //更新账户
                this.money = this.money - money;
                System.out.println(name + "后余额为" + this.money + "元");
            }else{
                System.out.println(name + "余额不足");
            }
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

