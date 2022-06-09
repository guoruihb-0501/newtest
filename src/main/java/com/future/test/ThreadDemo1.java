package com.future.test;

/**
 * @author guorui
 * @create 2022-06-08-21:47
 */
class Demo extends Thread
{   //继承Thread类需要重写run方法
    @Override
    public void run()
    {
        for(int x=0; x<60; x++)
            System.out.println("demo run----"+x);   //run方法的作用就是承载多线程需要运行的代码。
    }
}

class ThreadDemo1{
    public static void main(String[] args)
    {
        Demo d = new Demo();//创建好一个线程对象。
        d.start();//开启线程并执行该线程的run方法。   新线程  start方法创建线程然后运行run方法
        //运行d.start()主线程运行到这里会开辟一个新的线程开始执行，然后主线程继续向下执行与新开辟的线程抢夺cpu资源，是真正的多线程。
        //d.run();//仅仅是对象调用方法。而线程被Demo d创建了，并没有真正开启线程。
        //运行d.run()的结果只能是主线程先将d.run()方法运行完后，然后继续运行下面的程序，虽然有一个空线程但是并没有真正开启，所以不是真正的多线程程序

        for(int x=0; x<60; x++)   //主线程必须放在子线程之后，如果放在之前就会先运行完主线程，然后再开启子线程，达不到并行的效果
            System.out.println("Hello World!--"+x);    //主线程
    }
}