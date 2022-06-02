package com.future.test;

import java.io.File;

/**
 * @author guorui
 * @create 2022-06-01-14:11
 */
public class RecursionDemo1 {
    public static int lastBottleNumber = 0;  //剩余瓶数
    public static int lastCoverNumber = 0;   //剩余盖子数
    public static int totalBottleNumber = 0;  //总共购买的啤酒瓶数

    public static void main(String[] args) {
        //猴子吃桃
//        int s = f(10);
//        System.out.println(s);
        //搜索文件
//        find(new File("D:\\"), "logo");
        //啤酒问题
        beer(10);
        System.out.println("总共购买的啤酒瓶数:" + totalBottleNumber);
        System.out.println("剩余瓶数:" + lastBottleNumber);
        System.out.println("剩余盖子数:" + lastCoverNumber);

    }

    public static int f(int n){
        /*猴子摘桃当天吃了总量一半多一个，每天按此规则吃，第10天发现只剩1个，问第一天有多少桃子*/
        if (n == 1){
            return 1;
        }else{
            return ((f(n - 1) + 1) * 2);
        }
    }

    public static void find(File dir,String name){
        //先判断传入的是否是一个文件夹
        if (dir != null && dir.isDirectory()) {
            File[] files = dir.listFiles();
            //判断传入的是否是一个空文件夹，如果是空文件夹，则files数组为空或长度=0
            if (files != null && files.length > 0) {
                for (File file : files) {
                    //判断文件夹内的每个内容是否文件夹，如果是文件夹，则递归查找，否则对比文件名
                    if (file.isDirectory()) {
                        find(file, name);
                    } else {
                        if (file.getName().contains(name)) {
                            System.out.println(file.getAbsolutePath());
                        }
                    }
                }

            }
        }

    }

    public static void beer(int money){
        //每瓶啤酒2元，每2个空啤酒瓶可换1瓶啤酒，每4个啤酒瓶盖可换1瓶啤酒，10元能买多少瓶啤酒，剩下多少空啤酒瓶和啤酒瓶盖


        //检查传入的钱数可以买多少瓶啤酒
        int buyNumber = money / 2;
        totalBottleNumber = totalBottleNumber + buyNumber;
        //本次剩余的空瓶数和啤酒瓶盖数
        int coverNumber = lastCoverNumber + buyNumber;
        int bottleNumber = lastBottleNumber + buyNumber;

        int allMoney = 0;
        //计算本次剩余瓶盖数>4,则将其兑换成可兑换啤酒的钱数
        if (coverNumber >= 4){
            allMoney = allMoney + (coverNumber / 4) * 2;
        }
        //兑换完啤酒之后剩下的瓶盖数
        lastCoverNumber = coverNumber % 4;
        //计算本次剩余空瓶数>4,则将其兑换成可兑换啤酒的钱数
        if (bottleNumber >= 2){
            allMoney = allMoney + (bottleNumber / 2) * 2;
        }
        //兑换完啤酒之后剩下的空瓶数
        lastBottleNumber = bottleNumber % 2;

        //如果剩下的钱还够买1瓶啤酒则继续递归
        if (allMoney >= 2){
            beer(allMoney);
        }
    }



}
