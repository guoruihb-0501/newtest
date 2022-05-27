package com.future.test;

/**
 * @author guorui
 * @create 2022-05-20-14:26
 */
public class baozhuanglei {
    public static void main(String[] args) {
        String[] s1 = {"aaa","bbb","ccc"};
        printArray(s1);
        Integer[] i1 = {1,2,3};
        printArray(i1);
        String[] s2 = getArray(s1);
        Integer[] i2 = getArray(i1);
    }

    public static <T> T[] getArray(T[] arr){
        return arr;
    }

    public static <T> void printArray(T[] arr){
        if(arr != null){
            StringBuffer sb = new StringBuffer("[");
            for (int i = 0;i <= arr.length - 1;i++) {
                sb.append(arr[i]).append(i == arr.length - 1?"":",");
            }
            sb.append("]");
            System.out.println(sb);
        }else{
            System.out.println(arr);
        }
    }


}
