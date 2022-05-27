package com.future.test;

/**
 * @author guorui
 * @create 2022-05-11-14:50
 */
public class FactoryPattern {
    public static Computer createComputer(String info){
        switch (info){
            case "mac":
                Computer c1 = new Mac();
                c1.setName("Mac");
                c1.setPrice(9999);
                return c1;
            case "dell":
                Computer c2 = new Dell();
                c2.setName("Dell");
                c2.setPrice(8888);
                return c2;
            default:
                return null;
        }
    }
}
