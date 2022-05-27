package com.future.test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @author guorui
 * @create 2022-05-27-14:33
 */
public class CollectionsDemo1 {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<>();
        Collections.addAll(list1, "aaa","bbb","ccc");  //工具类Collections通过可变参数 批量添加参数
        Collections.addAll(list1, new String[] {"ddd","eee","fff","ggg"});   //工具类Collections通过可变参数 批量添加参数
        System.out.println(list1);
        Collections.shuffle(list1);  //工具类Collections 打乱list顺序
        System.out.println(list1);
        Collections.sort(list1);     //工具类Collections 给list排序
        System.out.println(list1);

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("张三",'男',12,"六年级1班","睡觉"));
        list2.add(new Student("李四",'男',13,"六年级1班","睡觉"));
        list2.add(new Student("王五",'女',11,"六年级1班","睡觉"));
        Collections.sort(list2, (o1, o2) -> {return o1.getAge() - o2.getAge();});  //工具类Collections 通过比较器对list排序
        System.out.println(list2);


    }
}
