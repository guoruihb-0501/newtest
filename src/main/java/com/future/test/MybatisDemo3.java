package com.future.test;

import com.future.mapper.TGrUser3Mapper;
import com.future.mapper.tGrUserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author guorui
 * @create 2022-06-15-11:15
 */
public class MybatisDemo3 {
    public static void main(String[] args) throws Exception {
        //加载mybatis配置文件 获取sqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        //获取sqlsession对象，用其执行sql
        SqlSession sqlSession = sqlSessionFactory.openSession();

        //获取代理对象，这种方式是mybatis内部实现的
        TGrUser3Mapper mapper = sqlSession.getMapper(TGrUser3Mapper.class);
        //使用代理获取对象集合
//        List<TGrUser3> users1 = mapper.selectAll();
//        System.out.println(users1);
//
//        int id1 = 9;
//        TGrUser3 user1 = mapper.selectById(id1);
//        System.out.println(user1);

//        List<TGrUser3> users2 = mapper.selectByCondition1(id1);
//        System.out.println(users2);
//
//        System.out.println("-----------------");
//        int id2 = 9;
//        String userName = "姓名";
//        userName = "%" + userName + "%";
//
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        String strMinDate = "2022-01-08";
//        String strMaxDate = "2022-12-31";
//        Date minDate = sdf1.parse(strMinDate);
//        Date maxDate = sdf1.parse(strMaxDate);
//        Map map = new HashMap();
//        map.put("id",id2);
//        map.put("userName",userName);
//        map.put("minDate",minDate);
//        map.put("maxDate",maxDate);
//        List<TGrUser3> users3 = mapper.selectByCondition2(map);
//        System.out.println(users3);


//        String vsbid = "2";
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy/MM/dd");
//        String strSbDate = "2020/01/02";
//        Date vSbDate = sdf1.parse(strSbDate);
//        Map map = new HashMap();
//        map.put("vsbid",vsbid);
//        map.put("vsbdate",strSbDate);
//        mapper.delSb(map);
//        sqlSession.close();
//        System.out.println(map.get("ret"));
//        System.out.println(map.get("rinfo"));


        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
        String vsdate = "2020-01-02";
        String vedate = "2020-01-05";
        //Date vSbDate = sdf1.parse(strSbDate);
        Map map = new HashMap();
        map.put("vedate",vedate);
        map.put("vsdate",vsdate);
        mapper.getRqInfo(map);
        sqlSession.close();
        System.out.println(map.get("ret"));
        //System.out.println(map.get("rcur"));
        List<RqInfo> list = (ArrayList<RqInfo>)map.get("rcur");
        for (RqInfo rqInfo : list) {
            System.out.println(rqInfo.getRq());
        }
    }
}
