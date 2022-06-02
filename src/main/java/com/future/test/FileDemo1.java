package com.future.test;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author guorui
 * @create 2022-06-01-9:38
 */
public class FileDemo1 {
    public static void main(String[] args) throws Exception {
        //绝对路径1和获取文件大小
        File f1 = new File("D:\\迅雷下载\\logo.png");
        long size1 = f1.length();
        System.out.println(size1);
        //绝对路径2和获取文件大小
        File f2 = new File("D:/迅雷下载/logo.png");
        long size2 = f2.length();
        System.out.println(size2);
        //相对路径1和获取文件大小
        File f3 = new File(".\\src\\logo.png");
        long size3 = f3.length();
        System.out.println(size3);
        //相对路径2  相对路径的 "." 代表项目所在的根文件夹 本例中的 d:\maven-workspace\newtest
        File f4 = new File("./src/logo.png");
        long size4 = f4.length();
        System.out.println(size4);
        System.out.println("----------分割线1----------");
        //检查文件是否存在  true
        File f5 = new File("./src/logo.png");
        System.out.println(f5.exists());
        //检查文件夹是否存在  true
        File f6 = new File("./src");
        System.out.println(f6.exists());
        //检查对象是否文件  true
        System.out.println(f5.isFile());
        //检查对象是否文件夹  true
        System.out.println(f6.isDirectory());
        System.out.println("----------分割线2----------");
        //检查文件的绝对路径  输出D:\maven-workspace\newtest\.\src\logo.png
        System.out.println(f5.getAbsolutePath());
        //检查文件的名称(含文件名)  输出.\src\logo.png  如果f5定义时用的是绝对路径，则在此输出绝对路径，如果定义时是相对路径则在此输出相对路径
        System.out.println(f5.getPath());
        //检查文件的名称(不含文件名)  输出.\src 如果f5定义时用的是绝对路径，则在此输出绝对路径，如果定义时是相对路径则在此输出相对路径
        System.out.println(f5.getParent());
        //检查文件的名称(不含路径)  输出logo.png
        System.out.println(f5.getName());
        //检查文件最后修改时间 毫秒值  1654048203145
        long time = f5.lastModified();
        System.out.println(time);
        //输出  2022-06-01 09:50:03
        System.out.println(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(time));
        System.out.println("----------分割线3----------");
        //创建一个文件，需要确保这个文件事先不存在，否则创建无意义
        File f7 = new File("./src/FileDemoTest1.txt");
        f7.createNewFile();  //如果文件原来不存在，则自动创建，如果打印则输出true或false
        //创建一个文件夹
        File f8 = new File("./src/TestDemo");
        f8.mkdir();  //先要确保src文件是存在的，才能创建TestDemo文件夹
        File f9 = new File("./src/bbb/ccc/ddd");
        System.out.println(f9.mkdir());  //因为bbb文件夹不存在，所以不能在bbb下继续创建ccc和ddd 输出false
        System.out.println(f9.mkdirs());  //mkdirs允许连环创建文件夹，连续创建bbb，ccc，ddd文件夹
        //删除文件和文件夹
        //文件不存在，也会返回true，但如果文件被打开，也会删除返回true，不会删除到回收站，而是直接删除
        System.out.println(f7.delete());
        //只能删除./src/bbb/ccc/ddd文件夹，不能连环删除 bbb和ccc文件夹 只能删除空文件夹
        System.out.println(f9.delete());
        System.out.println("----------分割线4----------");
        //如果想遍历文件夹，则必须是一个已经存在的文件夹，不能是一个文件或不存在的文件夹，否则会返回null，
        File f10 = new File("D:\\maven-workspace\\newtest\\src");
        //拿文件名称 只会显示列出文件夹根目录下的所有文件和文件夹名称，不会遍历子文件夹 隐藏文件也会显示
        String[] list = f10.list();
        for (String s : list) {
            System.out.println(s);
        }
        File[] files = f10.listFiles();  //拿文件对象 只会显示列出文件夹根目录下的所有文件和文件夹名称，不会遍历子文件夹
        for (File file : files) {
            System.out.println(file.getAbsolutePath());
        }

    }
}
