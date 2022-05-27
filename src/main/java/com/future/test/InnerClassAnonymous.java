package com.future.test;

import sun.misc.PostVMInitHook;

/**
 * @author guorui
 * @create 2022-05-19-16:12
 */
public class InnerClassAnonymous {
    public static void main(String[] args) {
//        ZooAnimal animal = new Tiger();
        ZooAnimal animal = new ZooAnimal() {
            @Override
            public void run() {
                System.out.println("Tiger run");
            }
        };
        animal.run();
    }
}

//class Tiger extends ZooAnimal{
//    @Override
//    public void run() {
//        System.out.println("Tiger run");
//    }
//}
abstract class ZooAnimal{
    public abstract void run();
}
