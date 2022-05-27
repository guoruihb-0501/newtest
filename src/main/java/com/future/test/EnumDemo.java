package com.future.test;

/**
 * @author guorui
 * @create 2022-05-16-16:58
 */
public class EnumDemo {
    public static void main(String[] args) {
        move(Season.SPRING);
    }
    public static void move(Season a){
        switch(a){
            case SPRING:
                System.out.println("春天");
                break;
            case SUMMER:
                System.out.println("夏天");
                break;
            case AUTUMN:
                System.out.println("秋天");
                break;
            case WINTER:
                System.out.println("冬天");
                break;
        }
    }
}
