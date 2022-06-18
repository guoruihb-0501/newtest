package com.future.mapper;

import com.future.test.TGrUser;
import com.future.test.TGrUser3;

import java.util.List;
import java.util.Map;

/**
 * @author guorui
 * @create 2022-06-14-12:31
 */
public interface TGrUser3Mapper {
    List<TGrUser3> selectAll();
    TGrUser3 selectById(int id);
    List<TGrUser3> selectByCondition1(int id);
    List<TGrUser3> selectByCondition2(Map map);
    Object delSb(Map map);
    Object getRqInfo(Map map);
}