package com.future.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Properties;

/**
 * @author guorui
 * @create 2022-06-13-16:01
 */
public class DruidDemo2 {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //创建加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("./src/main/resources/druid.properties"));
        //根据配置文件配置数据源
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);

        //通过druid获取数据库连接池
        Connection conn = ds.getConnection();
        String sql1 = "{ call sp_add_gr_user(?,?,?,?) } ";
        //PreparedStatement pstmt1 = null;
        CallableStatement cs = null;

        try {
            cs = conn.prepareCall(sql1);
            cs.registerOutParameter(1, Types.INTEGER);
            cs.setInt(1, 8);                              //输入参数
            cs.setString(2, "name8");
            String str1 = "2022-01-05";
            java.sql.Date date1 = java.sql.Date.valueOf(str1);   //字符串转换java.sql.Date
            cs.setDate(3, date1);
            cs.setDouble(4, 1.8);
            cs.executeUpdate();
            int id = cs.getInt(1);
            System.out.println(id);
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            //释放资源
            cs.close();
            conn.close();
        }
    }
}
