package com.future.test;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author guorui
 * @create 2022-05-12-13:48
 */
public class LambdaDemo3 {
    public static void main(String[] args) {
        JFrame win = new JFrame("登录窗口");
        JButton btn = new JButton("一个大按钮");
        //原型方法
//        btn.addActionListener(new ActionListener() {  //ActionListener 是一个只有一个抽象方法的接口
//            @Override
//            public void actionPerformed(ActionEvent e) {  //
//                System.out.println("您点击了我");
//            }
//        });

        //Lambda表达式1
        btn.addActionListener((ActionEvent e) -> {  //ActionListener 是一个只有一个抽象方法的接口
                System.out.println("您点击了我");
        });

        //Lambda表达式2  //参数类型可以不写，而且如果只有一个参数（这里的参数是e）小括号也可以省略
        btn.addActionListener(e -> {  //ActionListener 是一个只有一个抽象方法的接口
            System.out.println("您点击了我");
        });
        //Lambda表达式3  因为Lambda表达式只有一行代码，可以将{}和分号去掉
        btn.addActionListener(e -> System.out.println("您点击了我"));

        win.add(btn);
        win.setSize(400,300);
        win.setVisible(true);
    }
}
