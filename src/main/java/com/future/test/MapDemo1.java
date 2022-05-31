package com.future.test;

import java.util.*;
import java.util.function.BiConsumer;

/**
 * @author guorui
 * @create 2022-05-28-8:42
 */
public class MapDemo1 {
    public static void main(String[] args) {
        Map<String,Integer> maps1 = new HashMap<>();  //HashMap 是无序集合
        maps1.put("张三",12);
        maps1.put("李四",13);
        maps1.put("王五",11);
        maps1.put("王五",12);
        maps1.put("刘六",null);
        maps1.put(null,33);

//        maps1.forEach(new BiConsumer<String, Integer>() {
//            @Override
//            public void accept(String k, Integer v) {
//                System.out.println(k + "->" +v);
//            }
//        });
//        maps1.forEach((k,v) -> {
//            System.out.println(k + "->" +v);
//        });
    }
}
