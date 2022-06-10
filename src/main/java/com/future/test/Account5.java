package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-14:41
 */
public class Account5 {
    private String cardId;  //账户名称
    private double money;  //账户金额

    public Account5() {
    }

    public Account5(String cardId, double money) {
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

    public synchronized void depositMoney(double money) {
        //获取线程名称
        String name = Thread.currentThread().getName();

        try {
            if (this.money == 0){
                System.out.println(name + "成功，本次存钱" + money + "元");
                //更新账户
                this.money = this.money + money;
                System.out.println(name + "后余额为" + this.money + "元");
                this.notifyAll();
                this.wait();
            }else{
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public synchronized void drawMoney(double money) {
        //获取线程名称
        String name = Thread.currentThread().getName();
        //
        try {
            if (this.money >= money){
                System.out.println(name + "成功，本次取钱" + money + "元");
                //更新账户
                this.money = this.money - money;
                System.out.println(name + "后余额为" + this.money + "元");
                this.notifyAll();
                this.wait();
            }else{
                this.notifyAll();
                this.wait();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
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
