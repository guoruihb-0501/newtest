package com.future.test;

import com.future.mapper.TGrUser3Mapper;
import com.future.mapper.UserMapper;
import com.future.mapper.tGrUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author guorui
 * @create 2022-06-15-11:15
 */
public class MybatisDemo4 {
    public static void main(String[] args) throws Exception {
        //加载mybatis配置文件 获取sqlSessionFactory
        Class.forName("com.mysql.jdbc.Driver");
        String resource = "mybatis-config-mysql.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象，用其执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取代理对象，这种方式是mybatis内部实现的
        UserMapper mapper = sqlSession.getMapper(UserMapper.class);
        //使用代理获取对象集合

        System.out.println("-----------------");

        String userName1 = "姓名11";
        double userMoney1 = 1.11;
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String strUserBirthday1 = "2022-01-11";
        Date userBirthday1 = sdf1.parse(strUserBirthday1);

        Map map1 = new HashMap();
        User user = new User();
        user.setUserName(userName1);
        user.setUserBirthday(userBirthday1);
        user.setUserMoney(userMoney1);
        mapper.userAdd(user);
        int id1 = user.getId();
        System.out.println(id1);
        sqlSession.commit();

        System.out.println("-----------------");
        int id2 = 4;
        String userName2 = "姓名4";
        double userMoney2 = 1.4444;
        String strUserBirthday2 = "2022-01-04";
        Date userBirthday2 = sdf1.parse(strUserBirthday2);

        Map map2 = new HashMap();
        //map2.put("userName",userName2);
        //map2.put("userBirthday",userBirthday2);
        map2.put("userMoney",userMoney2);
        map2.put("id",id2);
        mapper.userUpdateById(map2);
        sqlSession.commit();

        System.out.println("-----------------");
        int id3 = 3;
        mapper.userDeleteById(id3);
        sqlSession.commit();

        System.out.println("-----------------");
        int[] ids = {7,8,9};
        mapper.userDeleteByIds(ids);
        sqlSession.commit();
        sqlSession.close();
    }
}