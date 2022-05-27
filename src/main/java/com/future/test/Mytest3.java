package com.future.test;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * @author guorui
 * @create 2022-05-04-9:28
 */
@Target({ElementType.METHOD,ElementType.TYPE})   //让注解只能在类和方法上起作用
@Retention(RetentionPolicy.RUNTIME)  //让注解在运行时起作用
public @interface Mytest3 {
}
