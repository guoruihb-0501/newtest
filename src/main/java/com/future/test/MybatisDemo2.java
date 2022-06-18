package com.future.test;

import com.future.mapper.tGrUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.List;

/**
 * @author guorui
 * @create 2022-06-14-12:24
 */
public class MybatisDemo2 {
    public static void main(String[] args) throws Exception {
        //加载mybatis配置文件 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象，用其执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取代理对象，这种方式是mybatis内部实现的
        tGrUserMapper mapper = sqlSession.getMapper(tGrUserMapper.class);
        //使用代理获取对象集合
        List<TGrUser> users = mapper.selectAll();
        System.out.println(users);
        sqlSession.close();
    }
}


