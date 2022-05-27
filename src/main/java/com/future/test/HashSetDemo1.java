package com.future.test;

import java.util.*;

/**
 * @author guorui
 * @create 2022-05-26-10:10
 */
public class HashSetDemo1 {
    public static void main(String[] args) {
//        Set<Student> sets = new TreeSet<>(new Comparator<Student>() {
//            @Override
//            public int compare(Student o1, Student o2) {
//                return o2.getAge() - o1.getAge();
//            }
//        });
        //如果age是int类型，可以这样比较  降序为 o1.getAge() - o2.getAge()
        Set<Student> sets = new TreeSet<>((o1,o2) -> {return o1.getAge() - o2.getAge();});
        //如果age是double类型，可以这样比较  降序为 Double.compare(o2.getAge() , o1.getAge())
        //Set<Student> sets = new TreeSet<>((o1,o2) -> {return Double.compare(o1.getAge() , o2.getAge());});
        Student s1 = new Student("王五",'女',11,"六年级3班","睡觉");
        Student s2 = new Student("王五",'女',11,"六年级3班","睡觉");
        Student s3 = new Student("张三",'男',12,"六年级1班","睡觉");
        sets.add(s1);
        sets.add(s2);
        sets.add(s3);

        System.out.println(sets);

    }
}
