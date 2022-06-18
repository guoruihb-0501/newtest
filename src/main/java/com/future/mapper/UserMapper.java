package com.future.mapper;

import com.future.test.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @author guorui
 * @create 2022-06-14-12:31
 */
public interface UserMapper {
    int userAdd(User user);
    void userUpdateById(Map map);
    void userDeleteById(int id);
    void userDeleteByIds(@Param("ids") int[] ids);
    List<User> selectByCondition2(Map map);
}