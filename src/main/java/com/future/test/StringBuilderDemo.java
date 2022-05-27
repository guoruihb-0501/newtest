package com.future.test;

/**
 * @author guorui
 * @create 2022-05-13-9:17
 */
public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder sb1 = new StringBuilder();
        sb1.append("abc");
        sb1.append(1);
        sb1.append(false);
        sb1.append(3.3);
        System.out.println(sb1);
        System.out.println("-----------------");
        //支持链式编程
        StringBuilder sb2 = new StringBuilder();
        sb2.append("abc").append(1).append(false).append(3.3);
        System.out.println(sb2);
        System.out.println("-----------------");
        //反转reverse
        sb2.reverse().append("456").append(true);
        System.out.println(sb2);
        //查看长度length
        System.out.println(sb2.length());
        //将stringbuilder转换回string
        //check(sb2);  //因为check方法只能接收string，所以需要转换
        String str = sb2.toString();
        check(str);
        System.out.println("-----------------");
        boolean a = false;
        String str1 = a + "";
        System.out.println(a);
        System.out.println("-----------------");
        Integer[] arr = {11,22,33,44,55};
        StringBuilder sb3 = new StringBuilder("[");
        for (int i=0;i < arr.length;i++) {
//            if (i != arr.length - 1) {
//                sb3.append(arr[i]).append(",");
//            } else {
//                sb3.append(arr[i]);
//            }
            sb3.append(arr[i]).append(i == arr.length - 1 ? "":", ");
        }
        sb3.append("]");
        String str3 = sb3.toString();
        System.out.println(str3);
    }
    public static void check(String str){

    }
}
