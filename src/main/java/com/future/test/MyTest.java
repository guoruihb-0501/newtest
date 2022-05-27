package com.future.test;

/**
 * @author guorui
 * @create 2022-05-04-8:57
 */
public @interface MyTest {
    public String name();    //public 可以不写，默认为public，变量之后要加()
    public String[] authors();
    public double price() default  9.9;  //定义一个有默认值的变量
}
