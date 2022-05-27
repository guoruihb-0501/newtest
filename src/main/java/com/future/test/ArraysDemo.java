package com.future.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * @author guorui
 * @create 2022-05-23-14:28
 */
public class ArraysDemo {
    public static void main(String[] args) {
        int[] arr1 = {12,21,3,14,5};
        String str1 = Arrays.toString(arr1);   //数组转字符串  输出 [12, 21, 3, 14, 5]
        System.out.println(str1);



        //排序
        Arrays.sort(arr1);
        System.out.println(Arrays.toString(arr1));   //排序后输出  [3, 5, 12, 14, 21]

        //二分搜索（前提是数组必须先排序）  返回数组索引 索引是排好序之后的索引 找不到则返回负数
        Arrays.sort(arr1);
        int index1 = Arrays.binarySearch(arr1, 21);   //返回4
        System.out.println(index1);
        int index2 = Arrays.binarySearch(arr1, 13);
        //返回-4 先将13插入到排序好后的数组[3,5,12,13,14,21]，13的位置=3，返回3*(-1)-1=-4
        System.out.println(index2);

        //降序排序
        //Integer[] arr2 = {12,21,3,14,5};
        //int数组转换为Integer数组
        int length = arr1.length;
        Integer[] arr2 = new Integer[length];
        for (int i=0;i <= length - 1;i++){
            arr2[i] = arr1[1];
        }
        Arrays.sort(arr2,new Comparator<Integer>(){
            //如果认为o1比o2大就返回正整数(比o2小就返回负整数，相等返回0) 表示是升序排序
            //如果认为o1比o2小就返回正整数(比o2大就返回负整数，相等返回0) 表示是降序排序
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        System.out.println(Arrays.toString(arr2));  //输出[21, 14, 12, 5, 3]

        //自定义比较器的高级用法
        Student[] stuarr = new Student[3];
        stuarr[0] = new Student("张三",'男',12,"六年级1班","睡觉");
        stuarr[1] = new Student("李四",'男',13,"六年级2班","睡觉");
        stuarr[2] = new Student("王五",'女',11,"六年级3班","睡觉");

        System.out.println(Arrays.toString(stuarr));
        //对学生的年龄进行升序排序
        Arrays.sort(stuarr,(o1, o2) ->{return o1.getAge() - o2.getAge();});
                //如果年龄是Double类型，但是这里return必须要返回整形，可以按如下方法做
                //return Double.compare(o1.getAge() , o2.getAge());  会将年龄差从double类型转换回整形

        System.out.println(Arrays.toString(stuarr));  //输出  [Student{name='王五', sex=女, age=11, className='六年级3班', hobby='睡觉'}, Student{name='张三', sex=男, age=12, className='六年级1班', hobby='睡觉'}, Student{name='李四', sex=男, age=13, className='六年级2班', hobby='睡觉'}]

    }
}
