package com.future.test;

/**
 * @author guorui
 * @create 2022-06-09-12:51
 */
public class ThreadDemo4 {
    public static void main(String[] args) throws Exception {
        for(int x=0; x<60; x++)
        {
            System.out.println("run..." + x);
            if (x==3){
                Thread.sleep(3000);
            }
        }
    }
}
