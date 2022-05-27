package com.future.test;

public class InnerClassStatic {
    public static int a = 100;
    public String hobby = "吃饭";
    private static int b = 200;
    public static class Inner{
        private int id;     //静态内部类可以创建私有变量
        private String name;

        public void show(){
            System.out.println("show" + name);
            System.out.println(a);  //静态内部类可以方便访问外部类的静态变量(public或private均可访问)
            System.out.println(b);
            //System.out.println(hobby);   //外部类成员变量不能访问，因为成员变量是属于对象的，内部类不知道要访问哪个对象
            //可以通过创建对象的方式访问
            InnerClassStatic in = new InnerClassStatic();
            System.out.println(in.hobby);
        }

        public Inner() {
        }

        public Inner(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setId(int id) {
            this.id = id;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
