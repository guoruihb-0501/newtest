package com.future.test;

import ch.qos.logback.core.joran.conditional.ThenAction;
import oracle.sql.DATE;

import java.sql.*;
import java.text.SimpleDateFormat;

/**
 * @author guorui
 * @create 2022-06-11-17:59
 */
public class JDBCDemo3 {
    public static void main(String[] args) throws Exception {
        //JDK1.5之后可以不再注册驱动
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Class.forName("com.mysql.jdbc.driver");
        String url_oracle = "jdbc:oracle:thin:@192.9.100.7:1521:bhhdqtls?useServerPrepStmts=true";  //oracle
        String url_mysql = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";  //mysql
        String username = "dbusrmkt";
        String password = "futuremkt";
        Connection conn = DriverManager.getConnection(url_oracle,username,password);
        String sql1 = "select id,name,money from test_gr2 where birth = ?";
        String sql2 = "insert into test_gr2 values (?,?,?,?)";
        conn.setAutoCommit(false);
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;

        try {
            pstmt1 = conn.prepareStatement(sql1);
            String str1 = "2022-01-04";
            java.sql.Date date1 = java.sql.Date.valueOf(str1);   //字符串转换java.sql.Date
            pstmt1.setDate(1,date1);
            ResultSet rs = pstmt1.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");
                System.out.println("id:" + id + " ; name:" + name + " ; money:" + money);
            }

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1,5);
            pstmt2.setString(2,"姓名5");
            String str2 = "2022-01-05";
            java.sql.Date date2 = java.sql.Date.valueOf(str2);   //字符串转换java.sql.Date
            pstmt2.setDate(3,date2);
            pstmt2.setDouble(4,1.5);
            pstmt2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            //释放资源
            pstmt2.close();
            conn.close();
        }
    }
}
