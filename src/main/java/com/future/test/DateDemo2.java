package com.future.test;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DateDemo2 {
    public static void main(String[] args) {
        System.out.println("1-----------------------------");  //获取当前日期时间
        LocalDate localdate1 = LocalDate.now();
        System.out.println(localdate1);  //输出2022-05-16
        LocalTime localtime1 = LocalTime.now();
        System.out.println(localtime1);  //输出14:58:37.945
        LocalDateTime localdatetime1 = LocalDateTime.now();
        System.out.println(localdatetime1);  //输出2022-05-16T14:58:37.945

        System.out.println("2-----------------------------");  //获取各日期参数
        System.out.println(localdatetime1.getYear());
        System.out.println(localdatetime1.getMonthValue());
        System.out.println(localdatetime1.getDayOfMonth());
        System.out.println(localdatetime1.getHour());
        System.out.println(localdatetime1.getMinute());
        System.out.println(localdatetime1.getSecond());
        System.out.println(localdatetime1.getDayOfYear());
        System.out.println(localdatetime1.getDayOfWeek());  //获取英文的星期几
        System.out.println(localdatetime1.getDayOfWeek().getValue());  //获取数字的星期几  星期一=1

        System.out.println("3-----------------------------");  //设置各日期参数
        LocalDate localdate2 = LocalDate.of(2011,11,11); //2011-11-11
        System.out.println(localdate2);
        LocalTime localtime2 = LocalTime.of(11,11,11);  //11:11:11
        System.out.println(localtime2);

        System.out.println("4-----------------------------");  //localdate等对象转换string
        String str1 = localdate1.toString();
        System.out.println(str1);  //localdate转换string
        String str2 = localtime1.toString();
        System.out.println(str2);  //localtime转换string

        System.out.println("5-----------------------------");  //string转换localdate
        DateTimeFormatter dtf5 = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localdatetimeaa = LocalDateTime.now();
        String straa = dtf5.format(localdatetimeaa);
        System.out.println(straa);
        String str5 = "2011-11-11 11:11:11";
        LocalDateTime localdatetime5 = LocalDateTime.parse(str5,dtf5);
        System.out.println(localdatetime5);

        System.out.println("6-----------------------------");  //localdatetime 转换 localdate localtime
        LocalDateTime localdatetime3 = LocalDateTime.now();
        LocalDate localdate3 = localdatetime3.toLocalDate();  //localdatetime 转换 localdate
        LocalTime localtime3 = localdatetime3.toLocalTime();  //localdatetime 转换 localtime

        System.out.println("7-----------------------------");  //日期加减
        localdate3 = localdate3.plusYears(1);     //向后加1年
        localdate3 = localdate3.plusMonths(-1);   //向前减1月
        localdate3 = localdate3.plusDays(-1);     //向前减1日
        System.out.println(localdate3);   //2011-11-11  -->  2012-10-10

        System.out.println("8-----------------------------");  //时间加减
        localtime3 = localtime3.plusHours(1);     //向后加1小时
        localtime3 = localtime3.plusMinutes(-1);   //向前减1分钟
        localtime3 = localtime3.plusSeconds(-1);     //向前减1秒
        System.out.println(localtime3);    //11:11:11  -->  12:10:10

        System.out.println("9-----------------------------");  //时间先后判断
        LocalDate localdate4 = localdatetime3.toLocalDate();
        System.out.println(localdate3);
        System.out.println(localdate3.equals(localdate4));  //判断两个日期是否相等
        System.out.println(localdate3.isAfter(localdate4));  //判断两个日期先后
        System.out.println(localdate3.isBefore(localdate4));

        System.out.println("10-----------------------------");  //时间戳，以及和date的互相转换
        Instant instant1 = Instant.now();  //为格林威治时间
        System.out.println(instant1);
        Date date1 = Date.from(instant1);  //instant转换date
        System.out.println(date1);
        Instant instant2 = date1.toInstant();  //date转换instant  为格林威治时间
        System.out.println(instant2);

        System.out.println("11-----------------------------");  //获取当前时区的时间戳
        Instant instant3 = Instant.now();  //为格林威治时间
        System.out.println(instant3);
        System.out.println(instant3.atZone(ZoneId.systemDefault()));  //将时间戳调到系统默认时区

        System.out.println("12-----------------------------");  //计算日期间隔
        LocalDate localdate121 = LocalDate.of(2011,11,11);
        LocalDate localdate122 = LocalDate.of(2012,12,12);
        Period period12 = Period.between(localdate121,localdate122);
        System.out.println(period12.getYears());
        System.out.println(period12.getMonths());
        System.out.println(period12.getDays());

        System.out.println("13-----------------------------");  //计算时间间隔
        LocalTime localtime131 = LocalTime.of(11,11,11);
        LocalTime localtime132 = LocalTime.of(12,12,12);
        Duration duration12 = Duration.between(localtime131,localtime132);

        System.out.println(duration12.toHours());  //相差小时数
        System.out.println(duration12.toMinutes());  //相差分钟数
        System.out.println(duration12.getSeconds());  //相差秒数

        LocalDateTime localdatetime131 = LocalDateTime.of(2011,11,11,11,11,11);
        LocalDateTime localdatetime132 = LocalDateTime.of(2012,12,12,12,12,12);
        Duration duration121 = Duration.between(localdatetime131,localdatetime132);
        System.out.println(duration121.toDays());  //相差天数

        System.out.println("14-----------------------------");  //计算时间间隔
        LocalDateTime localdatetime141 = LocalDateTime.of(2011,11,11,11,11,11);
        LocalDateTime localdatetime142 = LocalDateTime.of(2012,12,12,12,12,12);
        System.out.println("相差的年 " + ChronoUnit.YEARS.between(localdatetime141,localdatetime142));
        System.out.println("相差的月 " + ChronoUnit.MONTHS.between(localdatetime141,localdatetime142));
        System.out.println("相差的日 " + ChronoUnit.DAYS.between(localdatetime141,localdatetime142));
        System.out.println("相差的小时 " + ChronoUnit.HOURS.between(localdatetime141,localdatetime142));
        System.out.println("相差的分钟 " + ChronoUnit.MINUTES.between(localdatetime141,localdatetime142));
        System.out.println("相差的秒 " + ChronoUnit.SECONDS.between(localdatetime141,localdatetime142));
    }
}
