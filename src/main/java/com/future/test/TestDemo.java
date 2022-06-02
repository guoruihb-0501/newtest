package com.future.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author guorui
 * @create 2022-05-31-16:14
 */
public class TestDemo {
    public static void main(String[] args) throws ParseException {
        String str = "2022-11-11 11:11:11";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date d = sdf.parse(str);
        System.out.println(d);
    }
}
