package com.future.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guorui
 * @create 2022-06-12-10:47
 */
public class JDBCDemo2 {
    public static void main(String[] args) throws Exception {
        //JDK1.5之后可以不再注册驱动
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Class.forName("com.mysql.jdbc.driver");
        String url_oracle = "jdbc:oracle:thin:@192.9.100.7:1521:bhhdqtls";  //oracle
        String url_mysql = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";  //mysql
        String username = "dbusrmkt";
        String password = "futuremkt";
        Connection conn = DriverManager.getConnection(url_oracle,username,password);
        String sql1 = "select id,name,birth,money from test_gr2";
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery(sql1);
        List<TestGr2> list = new ArrayList<>();

        while (rs.next()){
            TestGr2 test = new TestGr2();
            int id = rs.getInt("id");
            String name = rs.getString("name");
            Date date = rs.getDate("birth");
            System.out.print("id:" + id + " ; ");
            System.out.print("name:" + name + " ; ");
            SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
            DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            String str1 = sdf1.format(date);
            LocalDate localdate1 = LocalDate.parse(str1,dtf1);
            int year = localdate1.getYear();
            int month = localdate1.getMonthValue();
            int day = localdate1.getDayOfMonth();
            String birth = year + "年" + month + "月" + day + "日";
            System.out.print("date:" + year + "年" + month + "月" + day + "日 ; ");
            double money = rs.getDouble("money");
            System.out.println("money:" + money);

            test.setId(id);
            test.setName(name);
            test.setBirth(birth);
            test.setMoney(money);
            test.toString();
            list.add(test);
        }

        for (TestGr2 testGr2 : list) {
            System.out.print("arraylist output : " + testGr2.getId() + " ; ");

            System.out.print(testGr2.getName() + " ; ");
            System.out.print(testGr2.getBirth() + " ; ");
            System.out.println(testGr2.getMoney());
        }

    }
}
