package com.future.test;

/**
 * @author guorui
 * @create 2022-05-19-15:01
 */
public class InnerClassMember {
    public static int a = 100;
    public String hobby = "吃饭";
    private static int b = 200;
    public class Inner2{
        private int id;     //静态内部类可以创建私有变量
        private String name;

        public void show(){
            System.out.println("show" + name);
            System.out.println(a);  //静态内部类可以方便访问外部类的静态变量(public或private均可访问)
            System.out.println(b);
            System.out.println(hobby);   //外部类成员变量可以访问，因为成员变量是属于外部类对象的，成员内部类也是属于外部类对象的
        }

        public Inner2() {
        }

        public Inner2(int id, String name) {
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
