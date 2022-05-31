package com.future.test;

import java.util.*;

/**
 * @author guorui
 * @create 2022-05-30-11:05
 */
public class TreeMapDemo1 {
    public static void main(String[] args) {

        Map<String, List<String>> map1 = new HashMap<>();  //定义嵌套集合 Map中嵌套List
        List<String> ls1 = new ArrayList<>();
        Collections.addAll(ls1,"B","C","D");   //定义子元素List数据
        List<String> ls2 = new ArrayList<>();
        Collections.addAll(ls2,"A","B","D");
        List<String> ls3 = new ArrayList<>();
        Collections.addAll(ls3,"A","B","C","D");
        map1.put("张三",ls1);  //将List添加如Map
        map1.put("李四",ls2);
        map1.put("王五",ls3);
        System.out.println(map1);  //输出  {李四=[A, B, D], 张三=[B, C, D], 王五=[A, B, C, D]}

        Map<String,Integer> map2 = new HashMap<>();   //定义输出map

        Collection<List<String>> cols = map1.values();   //将map中的list元素信息加入集合cols
        System.out.println(cols);  //输出  [[A, B, D], [B, C, D], [A, B, C, D]]
        for (List<String> col : cols) {    //cols嵌套集合的外层循环
            for (String s : col) {      //cols嵌套集合的子集的内层循环
                if (map2.containsKey(s)){        //判断map2中是否已经包含s这个key
                    map2.put(s,map2.get(s) + 1);   //有则+1，无则置1
                }else{
                    map2.put(s,1);
                }
            }
        }
        System.out.println(map2);  //输出 {A=2, B=3, C=2, D=3}

    }
}
