package com.future.test;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author guorui
 * @create 2022-06-14-10:44
 */
public class MybatisDemo1 {
    public static void main(String[] args) throws Exception {
        //加载mybatis配置文件 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象，用其执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<TGrUser> users = sqlSession.selectList("test.selectAll");
        System.out.println(users);
        sqlSession.close();
    }
}
