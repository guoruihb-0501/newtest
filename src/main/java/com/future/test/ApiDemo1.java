package com.future.test;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;

/**
 * @author guorui
 * @create 2022-05-13-10:20
 */
public class ApiDemo1 {
    public static void main(String[] args) {
        System.out.println(0.09+0.01);
        System.out.println("------------------");
        BigDecimal bd1 = BigDecimal.valueOf(0.09);  //将double 类型转换成BigDecimal类型
        BigDecimal bd2 = BigDecimal.valueOf(0.01);
        System.out.println(bd1.add(bd2));    //加法
        System.out.println(bd1.subtract(bd2));   //减法
        System.out.println(bd1.multiply(bd2));   //乘法
        System.out.println(bd1.divide(bd2));     //除法
        double d1 = bd1.add(bd2).doubleValue();  //将BigDecimal类型转换回double类型

        BigDecimal bd3 = BigDecimal.valueOf(10.0);  //将double 类型转换成BigDecimal类型
        BigDecimal bd4 = BigDecimal.valueOf(3.0);
        //System.out.println(bd3.divide(bd4));     //除法 无法得到3.3333......，因为BigDecimal要求一定要能除尽
        System.out.println(bd3.divide(bd4, 4,RoundingMode.CEILING));    //向上取整
        System.out.println(bd3.divide(bd4, 4,RoundingMode.FLOOR));  //向下取整
        System.out.println(bd3.divide(bd4,4, RoundingMode.HALF_UP));  //四舍五入
    }
}
