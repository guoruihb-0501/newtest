package com.future.test;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author guorui
 * @create 2022-05-30-15:26
 */
public class StreamDemo1 {
    public static double allmoney = 0;
    public static void main(String[] args) {
        System.out.println("--------------分割线0--------------");
        //stream流的初步使用
        List<String> ls = new ArrayList<>();
        Collections.addAll(ls,"张三丰","金毛狮王","阳顶天","张无忌","张强","张翠山","灭绝师太","张敏","张之洞","赵敏","周芷若","张三丰");
        ls.stream().filter(s -> s.startsWith("张"))     //过滤姓张的人
                .filter(s->s.length()==3)     //过滤名字为3个字的人  注意链式编程，在前面的基础上进行再过滤
                .forEach(s-> System.out.println(s));   //通过链式编程进行循环输出
        System.out.println("--------------分割线1--------------");
        //stream流之所以可以做到链式编程，是因为stream().filter()的输出类型仍然是一个stream流，所以可以继续在后面接filter，filter方法是一个中间方法
        //但forEach方法的输出不再是一个stream，所以它之后不再能接新的方法，forEach是一个终结方法

        Collection<String> list = new ArrayList<>();  //list.add("abc");
        Collections.addAll(list,"张三丰","金毛狮王","阳顶天","张无忌","张强","张翠山","灭绝师太","张敏","张之洞","赵敏","周芷若","张三丰");
        Collection<String> set = new HashSet<>();     //set.add("abc");
        Collections.addAll(set,"张三丰set","金毛狮王set","阳顶天set","张无忌set","张强set","张翠山set","灭绝师太set","张敏set","张之洞set","赵敏set","周芷若set");
        Map<String,Integer> map = new HashMap<>();    //map.put("abc",123);
//        map.put("张三丰",123);
//        map.put("金毛狮王",124);
//        map.put("阳顶天",125);
//        map.put("张无忌",126);
//        map.put("张强",127);
//        map.put("张翠山",128);
//        map.put("灭绝师太",129);
//        map.put("张敏",130);
//        map.put("张之洞",131);
//        map.put("赵敏",132);
//        map.put("周芷若",133);
        String[] arr = {"张三丰","金毛狮王","阳顶天","张无忌","张强","张翠山","灭绝师太","张敏","张之洞","赵敏","周芷若"};


        Stream<String> stream_ls = list.stream();    //集合的.stream方法可以输出一个Stream流对象
        Stream<String> stream_set = set.stream();
        Stream<String> stream_map_key = map.keySet().stream();    //将所有的key的集合输出一个Stream流对象
        Stream<Integer> stream_map_value = map.values().stream(); //将所有的value的集合输出一个Stream流对象
        Stream<Map.Entry<String,Integer>> stream_map_entry = map.entrySet().stream();  //将所有的键值对的集合输出一个Stream流对象
        Stream<String> stream_arr = Arrays.stream(arr);  //通过Arrays工具类将数组转换成Stream流对象
        System.out.println("--------------分割线2--------------");

        //Stream流的常用api
        //filter方法和forEach方法 //这里的s可以认为是集合中的每一个元素（集合的元素类型是String类型的）
        list.stream().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));  //列出集合中所有姓张的元素
        System.out.println("--------------分割线3--------------");
        //filter方法和count方法  count方法也是一个终结方法，输出一个long类型变量
        Long sl = list.stream().filter(s -> s.length() == 3).count();  //列出集合中元素长度为3的元素个数
        System.out.println(sl);
        System.out.println("--------------分割线4--------------");
        //filter方法和limit方法  limit方法也是一个中间方法 获得集合中的前几个元素
        list.stream().filter(s -> s.startsWith("张")).limit(2).forEach(s -> System.out.println(s));  //列出集合中姓张的前两个元素
        System.out.println("--------------分割线5--------------");
        //filter方法和skip方法  skip方法也是一个中间方法 跳过集合中的前几个元素
        list.stream().filter(s -> s.startsWith("张")).skip(2).forEach(s -> System.out.println(s));  //列出集合中姓张的元素后，跳过前两个元素之后的输出
        System.out.println("--------------分割线6--------------");
        //filter方法和map方法  map方法也是一个中间方法 对集合中的元素进行加工
        list.stream().filter(s -> s.startsWith("张")).map(s -> s + "list").forEach(s -> System.out.println(s));  //列出集合中姓张的元素后，给每个元素后面加一个list字符串
        System.out.println("--------------分割线7--------------");
        list.stream().filter(s -> s.startsWith("张")).map(s -> new Student(s)).forEach(t -> System.out.println(t));  //列出集合中姓张的元素后，将每个元素加工成一个Student对象 因为有构造器 public Student(String name)
        System.out.println("--------------分割线8--------------");
        //concat合并流
        Stream<String> s1 = list.stream().filter(s -> s.startsWith("张"));
        Stream<String> s2 = set.stream().filter(s -> s.startsWith("张"));
        Stream<String> s3 = Stream.concat(s1,s2);
        s3.forEach(s -> System.out.println(s));
        System.out.println("--------------分割线9--------------");
        //distinct方法去重  distinct方法也是一个中间方法 对集合中的元素进行去重
        list.stream().distinct().filter(s -> s.startsWith("张")).forEach(s -> System.out.println(s));  //列出集合中姓张的元素后，然后去重
        System.out.println("--------------分割线10--------------");
        //综合应用api
        List<Employee> one = new ArrayList<>();
        one.add(new Employee("猪八戒",'男',30000,20000,null));
        one.add(new Employee("孙悟空",'男',20000,50000,null));
        one.add(new Employee("沙僧",'男',10000,2000,null));
        one.add(new Employee("白龙马",'男',15000,5000,null));

        List<Employee> two = new ArrayList<>();
        two.add(new Employee("金毛狮王",'男',10000,10000,null));
        two.add(new Employee("紫衫龙王",'女',20000,20000,null));
        two.add(new Employee("白眉鹰王",'男',30000,30000,null));
        two.add(new Employee("青翼蝠王",'男',40000,40000,null));

        //获取one集合salary和bonus之和最高的元素  max方法需要比较器，只会有一个结果，所以无法forEach，但可以通过get()方法输出Employee
        Employee e = one.stream().
                max((o1,o2) -> Double.compare((o1.getSalary() + o1.getBonus()) , (o2.getSalary() + o2.getBonus())))
                .get();
        System.out.println(e);
        //也可以用map方法将最高薪酬的对象的结果加工出来成为一个map
        Map<String,Double> map_employee = new HashMap<>();
        one.stream().
                max((o1,o2) -> Double.compare((o1.getSalary() + o1.getBonus()) , (o2.getSalary() + o2.getBonus())))
                .map(s -> map_employee.put(s.getName(),s.getSalary() +s.getBonus()));
        System.out.println(map_employee);
        System.out.println("--------------分割线11--------------");
        //在one集合中去除最高薪酬和最低薪酬，算出平均薪酬
        one.stream()
                //先按薪酬排序
                .sorted((o1,o2) -> Double.compare((o1.getSalary() + o1.getBonus()) , (o2.getSalary() + o2.getBonus())))
                .skip(1)  //去除最高薪酬
                .limit(one.size() - 2)   //去掉最高薪酬之后取one.size() - 2个元素，相当于去掉了最低薪酬元素
                .forEach(s -> allmoney += (s.getBonus() + s.getSalary()));
        double avg_money = allmoney / (one.size() - 2);
        System.out.println(avg_money);
        System.out.println("--------------分割线12--------------");
        //收集Stream流回集合或数组
        Stream<String> s_list = list.stream().filter(s -> s.startsWith("张"));
        //Stream流转换回集合List对象
        List<String> lista = s_list.collect(Collectors.toList());
        System.out.println(lista);
        //1个Stream流，只能使用一次，如果需要再次使用，需要再次声明
        Stream<String> s_set = list.stream().filter(s -> s.startsWith("张"));  //没有本行重新生成stream对象，下面1行语句会报错
        //Stream流转换回集合set对象
        Set<String> seta = s_set.collect(Collectors.toSet());
        System.out.println(seta);
        //1个Stream流，只能使用一次，如果需要再次使用，需要再次声明
        Stream<String> s_arr = list.stream().filter(s -> s.startsWith("张"));  //没有本行重新生成stream对象，下面1行语句会报错
        //Stream流转换回数组对象
        Object[] arra = s_arr.toArray();
        for (Object o : arra) {
            System.out.println(o);
        }
        System.out.println("--------------分割线13--------------");
    }
}
