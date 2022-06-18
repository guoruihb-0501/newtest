package com.future.test;

import ch.qos.logback.core.joran.conditional.ThenAction;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author guorui
 * @create 2022-06-11-17:59
 */
public class JDBCDemo1 {
    public static void main(String[] args) throws Exception {
        //JDK1.5之后可以不再注册驱动
        //Class.forName("oracle.jdbc.driver.OracleDriver");
        //Class.forName("com.mysql.jdbc.driver");
        String url_oracle = "jdbc:oracle:thin:@192.9.100.7:1521:bhhdqtls";  //oracle
        String url_mysql = "jdbc:mysql://127.0.0.1:3306/db1?useSSL=false";  //mysql
        String username = "dbusrmkt";
        String password = "futuremkt";
        Connection conn = DriverManager.getConnection(url_oracle,username,password);
        //DML语句
        String sql1 = "update grade8_01 set sign1 = '1'";
        //DDL语句
        String sql2 = "drop table grade8_02";
        conn.setAutoCommit(false);
        //获取执行对象
        Statement stmt = conn.createStatement();
        try {
            //执行sql返回受影响的行数
            int count1 = stmt.executeUpdate(sql1);
            System.out.println(count1);
            if (count1 > 0) {
                System.out.println("语句1修改成功");
            } else{
                System.out.println("语句2修改失败");
            }
            int a = 3/0;
            //加上下面的try catch 那么sql语句2出现错误将不会影响sql语句1的执行
            try {
                stmt.executeUpdate(sql2);
                System.out.println("语句2执行成功");
            } catch (SQLException e) {
                e.printStackTrace();
                System.out.println("语句2执行失败");
            }
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            //释放资源
            stmt.close();
            conn.close();
        }

    }
}
