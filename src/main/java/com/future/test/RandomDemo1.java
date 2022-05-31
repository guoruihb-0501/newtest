package com.future.test;

import java.util.Random;

/**
 * @author guorui
 * @create 2022-05-30-10:25
 */
public class RandomDemo1 {
    public static void main(String[] args) {
        Random r = new Random();
        System.out.println(r.nextInt(10));  //随机生成1-9
        System.out.println(r.nextDouble());   //随机生成0-1之间的小数
        System.out.println(String.format("%.2f", r.nextDouble() * 30 + 15));   //随机生成15-45之间的小数（小数点后保留2位）
        String[] sarr = {"A","B","C","D"};
        System.out.println(sarr[r.nextInt(sarr.length)]);  //从数组saar中随机选择一个字母

    }
}
