package com.future.test;

/**
 * @author guorui
 * @create 2022-06-12-11:24
 */
public class TestGr2 {
    private int id;
    private String name;
    private String birth;
    private double money;

    public TestGr2() {
    }

    public TestGr2(int id, String name, String birth, double money) {
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.money = money;
    }

    @Override
    public String toString() {
        return "TestGr2{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", money=" + money +
                '}';
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public double getMoney() {
        return money;
    }

    public void setMoney(double money) {
        this.money = money;
    }
}
