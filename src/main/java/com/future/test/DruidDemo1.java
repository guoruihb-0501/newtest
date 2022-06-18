package com.future.test;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
public class DruidDemo1 {
    public static void main(String[] args) throws Exception {
        System.out.println(System.getProperty("user.dir"));
        //创建加载配置文件
        Properties prop = new Properties();
        prop.load(new FileInputStream("./src/main/resources/druid.properties"));
        //根据配置文件配置数据源
        DataSource ds = DruidDataSourceFactory.createDataSource(prop);
        //通过druid获取数据库连接池
        Connection conn = ds.getConnection();
        String sql1 = "select id,name,money,birth from test_gr2 where birth = ?";
        String sql2 = "insert into test_gr2 values (?,?,?,?)";
        conn.setAutoCommit(false);
        PreparedStatement pstmt1 = null;
        PreparedStatement pstmt2 = null;
        List<TestGr2> list = new ArrayList<>();

        try {
            pstmt1 = conn.prepareStatement(sql1);
            String str1 = "2022-01-04";
            java.sql.Date date1 = java.sql.Date.valueOf(str1);   //字符串转换java.sql.Date
            pstmt1.setDate(1,date1);
            ResultSet rs = pstmt1.executeQuery();
            TestGr2 test = null;

            while (rs.next()) {
                test = new TestGr2();
                int id = rs.getInt("id");
                String name = rs.getString("name");
                double money = rs.getDouble("money");

                Date birth = rs.getDate("birth");
                SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
                DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                String str2 = sdf1.format(birth);
                LocalDate localdate1 = LocalDate.parse(str1,dtf1);
                int year = localdate1.getYear();
                int month = localdate1.getMonthValue();
                int day = localdate1.getDayOfMonth();
                String birth2 = year + "年" + month + "月" + day + "日";

                test.setId(id);
                test.setName(name);
                test.setBirth(birth2);
                test.setMoney(money);

                list.add(test);
            }

            pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1,7);
            pstmt2.setString(2,"姓名7");
            String str2 = "2022-01-07";
            java.sql.Date date2 = java.sql.Date.valueOf(str2);   //字符串转换java.sql.Date
            pstmt2.setDate(3,date2);
            pstmt2.setDouble(4,1.7);
            pstmt2.executeUpdate();
            conn.commit();
        } catch (Exception e) {
            e.printStackTrace();
            conn.rollback();
        } finally {
            //释放资源
            pstmt1.close();
            pstmt2.close();
            conn.close();
        }

        for (TestGr2 testGr2 : list) {
            System.out.print("arraylist output : " + testGr2.getId() + " ; ");
            System.out.print(testGr2.getName() + " ; ");
            System.out.print(testGr2.getBirth() + " ; ");
            System.out.println(testGr2.getMoney());
        }
    }
}
