package com.future.test;

/**
 * @author guorui
 * @create 2022-05-04-9:18
 */

/**
 * @author guorui
 * @create 2022-05-04-9:11
 */
public @interface Mytest2 {
    String value();
    double price() default 9.9;
    String name() default "test";
}
