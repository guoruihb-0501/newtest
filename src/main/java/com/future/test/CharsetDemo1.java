package com.future.test;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guorui
 * @create 2022-06-01-20:14
 */
public class CharsetDemo1 {
    public static void main(String[] args) throws Exception {
//        String name = "abc我爱你中国";
////        //将字符串按GBK编码  前后必须一致，可以用GBK,UTF-8,ISO8859-1
////        byte[] bytes = name.getBytes("ISO8859-1");
////        System.out.println(bytes.length);
////        System.out.println(Arrays.toString(bytes));
////        //将字符串按GBK解码  前后必须一致，可以用GBK,UTF-8,ISO8859-1
////        String rs = new String(bytes,"UTF-8");
////        System.out.println(rs);
        //取绝对数
        System.out.println(Math.abs(-10.2));   //返回10.2
//向上取整
        System.out.println(Math.ceil(4.01));   //返回5.0
//向下取整
        System.out.println(Math.floor(4.99));   //返回4.0
//四舍五入
        System.out.println(Math.round(4.499));   //返回4
        System.out.println(Math.round(4.501));   //返回5
//指数次方
        System.out.println(Math.pow(2,3));   //返回8.0
        Date date8 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date8 = sdf1.parse("2001-01-01 11:11:11");
        Calendar calendar8 = Calendar.getInstance();
        calendar8.setTime(date8);  //date对象转换为calendar对象

    }
}
