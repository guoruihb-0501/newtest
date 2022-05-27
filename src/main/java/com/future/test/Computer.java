package com.future.test;

/**
 * @author guorui
 * @create 2022-05-11-14:32
 */
public abstract class Computer {
    private String name;
    private double price;

    public void start(){

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
