package com.future.test;

class Ticket  extends Thread
{
    private static int tick = 100;   //静态变量可以保证四个线程共享同一个tick变量
    public void run()
    {
        while(true)
        {
            if(tick>0)
            {
                System.out.println(this.getName()+"....sale : "+ tick--);
            }
        }
    }
}

class  TicketDemo
{
    public static void main(String[] args)
    {
        Ticket t1 = new Ticket();
        Ticket t2 = new Ticket();
        Ticket t3 = new Ticket();
        Ticket t4 = new Ticket();
        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}