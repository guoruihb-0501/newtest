package com.future.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.function.Consumer;

/**
 * @author guorui
 * @create 2022-05-23-16:13
 */
public class CollectionDemo1 {
    public static void main(String[] args) {
        Collection<String> list = new ArrayList();
        list.add("张三");
        list.add("李四");
        list.add("23");
        list.add("true");
        System.out.println(list);  //不需要转换toString  输出有序 [张三, 李四, 23, true]
        System.out.println("增强for循环-------------------------");
        //常见遍历方法之增强for循环 list.for
        for (String s : list) {
            System.out.println(s);
        }
        //类似数组的遍历方法 arr.for
        //int[] arr = {1,2,3,4,5};
        //for (int i : arr) {
        //   System.out.println(i);
        //}
        System.out.println("迭代器-------------------------");
        //常见遍历方法之迭代器
        Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        System.out.println("Lambda表达式-------------------------");
        //常见遍历方法之Lambda表达式  jdk8之后可用  不建议下面的写法，不够简化
        //list.forEach(new Consumer<String>() {
            //@Override
            //public void accept(String s) {
            //System.out.println(s);
            //}
        //});
        //上述方法经过Lambda表达式简化如下  建议此方法 简化而且易读性强
        list.forEach(s -> {
            System.out.println(s);
        });
        //还可以进一步简化成如下  不建议如下方法，虽然极度简化，但不易读
        //list.forEach(System.out::println);
        System.out.println("-------------------------");
        Student s0 = new Student("张三",'男',12,"六年级1班","睡觉");
        Student s1 = new Student("李四",'男',13,"六年级2班","睡觉");
        Student s2 = new Student("王五",'女',11,"六年级3班","睡觉");
        Collection<Student> list_stu = new ArrayList();
        list_stu.add(s0);
        list_stu.add(s1);
        list_stu.add(s2);
        for (Student student : list_stu) {
            System.out.println(student.toString());
        }
    }
}


