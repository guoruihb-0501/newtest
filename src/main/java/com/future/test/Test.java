package com.future.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * @author guorui
 * @create 2022-05-25-15:50
 */
public class Test {
        public static void main(String[] args)
        {
            ArrayList<String> al1 = new ArrayList<>();
            al1.add("a");
            al1.add("a");
            al1.add("b");
            al1.add("c");
            al1.add("d");
            System.out.println(al1);
            //删除所有=a的元素  方法1  从前往后删
//            for (int i = 0; i <= al1.size() - 1; i++){
//                String ele = al1.get(i);
//                if ("a".equals(ele)){
//                    al1.remove(i);
//                    i--;
//                }
//            }
            System.out.println(al1);
            //删除所有=a的元素  方法2  从后往前删
            for (int i = al1.size() - 1; i >= 0; i--){
                String ele = al1.get(i);
                if ("a".equals(ele)){
                    al1.remove(i);
                }
            }
            System.out.println(al1);

        }

}
