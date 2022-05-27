package com.future.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author guorui
 * @create 2022-05-16-10:26
 */
public class DateDemo {
    public static void main(String[] args) throws ParseException {
        //Date方法
        System.out.println("1----------------------------");
        System.out.println("1.1---");
        Date date1 = new Date();  //无参构造器，获取当前日期
        System.out.println(date1);
        long time1 = date1.getTime();  //日期转换毫秒值
        System.out.println(time1);  //从1970.01.01到当前的毫秒数
        long time2 = time1 + (5 * 60 * 60 + 4 * 60 + 3) * 1000;  //得到当前时间之后5小时4分3秒之后的毫秒值
        Date date2 = new Date(time2);  //毫秒值转换日期(通过构造器转换)
        System.out.println(date2);
        System.out.println("---");
        Date date3 = new Date();
        date3.setTime(time2);
        System.out.println(date3);    //毫秒值转换日期(通过setTime方法转换)
        System.out.println("1.1---");
        System.out.println("1----------------------------");
        //SimpleDateFormat方法  1.用于格式化日期时间显示 2.将字符串转换日期时间
        System.out.println("2----------------------------");
        System.out.println("2.1---");
        Date date4 = new Date();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy年MM月dd日 HH点mm分ss秒 EEE a");
        String str1 = sdf1.format(date4);  //日期对象转换字符串
        String str2 = sdf2.format(date4);  //日期对象转换字符串
        System.out.println(str1);   //2022-05-16 11:13:21
        System.out.println(str2);   //2022年05月16日 11点13分21秒 星期一 上午
        System.out.println("2.2---");
        long time4 = date4.getTime();
        time4 = time4 + (5 * 60 * 60 + 4 * 60 + 3) * 1000;  //得到当前时间之后5小时4分3秒之后的毫秒值
        String str3 = sdf1.format(time4);  //时间毫秒值转换为字符串
        System.out.println(str3);  //2022-05-16 16:17:24
        System.out.println("2.3---");
        String str5 = "2022年1月1日 3点29分10秒";
        SimpleDateFormat sdf5 = new SimpleDateFormat("yyyy年M月d日 H点m分s秒");  //字符串转换为日期对象
        Date date5 = sdf5.parse(str5);   //字符串转换为日期对象
        long time5 = sdf5.parse("2022年1月1日 3点29分10秒").getTime();  //字符串转换时间毫秒值
        System.out.println(sdf1.format(date5));
        System.out.println(time5);
        System.out.println("2.3---");
        System.out.println("2----------------------------");
        //日期比较
        System.out.println("3----------------------------");
        System.out.println("3.1---");
        Date date6 = new Date();
        long time6 = date6.getTime();
        time6 = time6 + (5 * 60 * 60 + 4 * 60 + 3) * 1000;
        Date date7 = new Date(time6);
        System.out.println(date7.after(date6));  //判断date7是否大于date6
        System.out.println(date7.before(date6));  //判断date7是否小于date6
        System.out.println("3.1---");
        //Calendar对象
        System.out.println("4----------------------------");
        System.out.println("4.1---");
        Calendar calendar1 = Calendar.getInstance();  //获取当前日期的Calendar对象
        System.out.println(calendar1);
        System.out.println(calendar1.get(Calendar.YEAR));  //得到当前日期的年
        System.out.println(calendar1.get(Calendar.MONTH) + 1);  //得到当前日期的月 默认从0开始记月，所以要加1
        System.out.println(calendar1.get(Calendar.DATE));
        System.out.println(calendar1.get(Calendar.HOUR));
        System.out.println(calendar1.get(Calendar.MINUTE));
        System.out.println(calendar1.get(Calendar.SECOND));
        System.out.println(calendar1.get(Calendar.WEEK_OF_YEAR));
        System.out.println(calendar1.get(Calendar.DAY_OF_YEAR));
        System.out.println(calendar1.get(Calendar.WEEK_OF_MONTH));
        System.out.println(calendar1.get(Calendar.DAY_OF_MONTH));
        System.out.println(calendar1.get(Calendar.DAY_OF_WEEK));
        System.out.println(calendar1.get(Calendar.MILLISECOND));
        System.out.println("4.2---");
        calendar1.set(Calendar.YEAR,2023);   //设置当前时间为2023-11-11 11:11:11
        calendar1.set(Calendar.MONTH,11);
        calendar1.set(Calendar.DATE,11);
        calendar1.set(Calendar.HOUR,11);
        calendar1.set(Calendar.MINUTE,11);
        calendar1.set(Calendar.SECOND,11);
        System.out.println("4.3---");
        String str8 = "2011年1月1日 1点1分1秒";
        SimpleDateFormat sdf8 = new SimpleDateFormat("yyyy年M月d日 H点m分s秒");  //字符串转换为日期对象
        Date date8 = sdf8.parse(str8);   //字符串转换为日期对象
        Calendar calendar8 = Calendar.getInstance();
        calendar8.setTime(date8);  //date对象转换为calendar对象，用date8对象给calendar8对象赋值
        System.out.println(calendar8.get(Calendar.YEAR));
        System.out.println("4.4---");
        Calendar calendar9 = Calendar.getInstance();
        Date date9 = calendar9.getTime();   //Calendar转换为日期对象
        System.out.println(date9);
        System.out.println("4.4---");
        System.out.println("4----------------------------");
    }
}
