package com.future.test;

import java.util.Date;

public class User {
    private int id;
    private String userName;
    private double userMoney;
    private Date userBirthday;

    public User() {
    }

    public User(int id, String userName, double userMoney, Date userBirthday) {
        this.id = id;
        this.userName = userName;
        this.userMoney = userMoney;
        this.userBirthday = userBirthday;
    }

    @Override
    public String toString() {
        return "TGrUser3{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", userMoney=" + userMoney +
                ", userBirthday=" + userBirthday +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public double getUserMoney() {
        return userMoney;
    }

    public void setUserMoney(double userMoney) {
        this.userMoney = userMoney;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }
}
