package com.future.test;

/**
 * @author guorui
 * @create 2022-05-19-14:41
 */
public class TestInnerClass {
    public static void main(String[] args) {
        InnerClassMember.Inner2 in2 = new InnerClassMember().new Inner2();
        in2.setName("张三");
        in2.show();
    }
}
