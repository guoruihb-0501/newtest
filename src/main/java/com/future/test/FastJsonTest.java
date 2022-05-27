package com.future.test;

import com.alibaba.fastjson.JSONObject;

/**
 * @author guorui
 * @create 2022-05-19-11:21
 */
public class FastJsonTest {
    public static void main(String[] args) {
        Student student = new Student("张三",'1',18,"高三一班","吃饭");
        String json = JSONObject.toJSONString(student);
        System.out.println(json);
        Student student1 = JSONObject.parseObject(json,Student.class);
        System.out.println(student1);
    }
}
