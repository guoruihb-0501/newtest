package com.future.test;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author guorui
 * @create 2022-05-12-13:40
 */
public class LambdaDemo2 {
    public static void main(String[] args) {
        Integer[] ages = {1,3,2,4};

        //原型方法
//        Arrays.sort(ages, new Comparator<Integer>() {  //Comparator是一个只有一个抽象方法的接口 有FunctionalInterface注解修饰
//            @Override
//            public int compare(Integer o1, Integer o2) {
//                return o2 - o1;
//            }
//        });

        //Lambda表达式1
        Arrays.sort(ages, (Integer o1, Integer o2) -> {
            return o2 - o1;
        });
        //Lambda表达式2   参数类型也可以省略不写
        Arrays.sort(ages, (o1, o2) -> {
            return o2 - o1;
        });
        //Lambda表达式3   参数类型也可以省略不写  如果Lambda只有一行代码，可以省去{}和分号以及
        Arrays.sort(ages, (o1, o2) -> o2 - o1);


        System.out.println(Arrays.toString(ages));
    }
}
