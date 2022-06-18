package com.future.test;

import java.util.Date;

/**
 * @author guorui
 * @create 2022-06-14-10:39
 */
public class TGrUser {
    private int id;
    private String name;
    private double money;
    private Date birthday;

    @Override
    public String toString() {
        return "TGrUser{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", money=" + money +
                ", birthday=" + birthday +
                '}';
    }

    public TGrUser() {
    }

    public TGrUser(int id, String name, double money, Date birthday) {
        this.id = id;
        this.name = name;
        this.money = money;
        this.birthday = birthday;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }
}
