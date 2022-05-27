package com.future.test;

import java.util.Arrays;

/**
 * @author guorui
 * @create 2022-05-27-13:31
 */
public class VariableParamDemo1 {
    public static void main(String[] args) {
        sum();   //不传参数
        sum(10);  //传1个参数
        sum(10,20,40);    //传多个参数
        sum(new int[] {10,20,39});  //传数组
    }
    public static void sum(int...nums){
        System.out.println("元素个数：" + nums.length);
        System.out.println("元素内容：" + Arrays.toString(nums));
    }
}
