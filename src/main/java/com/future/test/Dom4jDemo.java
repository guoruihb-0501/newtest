package com.future.test;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.jupiter.api.Test;
import org.junit.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author guorui
 * @create 2022-05-07-16:41
 */
public class Dom4jDemo {
    @Test
    public void dom4jDemoTest() throws Exception {
        //创建1个dom4j解析器对象 SAXReader，代表了整个dom4j框架
        SAXReader sr = new SAXReader();
        //加载xml文件成为一个DOCMENT对象
        //从工程根目录开始定位xml文件  java.io默认定位到工程根目录
        Document document = sr.read(new File("./src/main/webapp/WEB-INF/data.xml"));
        //获取根节点
        Element root = document.getRootElement();
        System.out.println(root.getName());
        System.out.println("-------------------分割线-------------------");

        //获取根元素下的所有子元素，并将每个子元素的所有信息存入Book对象，并将每个Book对象存入list
        List<Element> ziElements1 = root.elements();
        for (Element ziElement1 : ziElements1) {
            System.out.println(ziElement1.getName());  //遍历显示标签名称
            //声明List对象 类型为Book
            List<Book> books = new ArrayList<>();
            //声明Book对象
            Book book = new Book();
            //为book对象的每个属性赋值
            book.setId(Integer.valueOf(ziElement1.attributeValue("id")));
            book.setType(ziElement1.attributeValue("type"));
            book.setName(ziElement1.elementText("书名"));
            book.setWriter(ziElement1.elementText("作者"));
            book.setPrice(Double.valueOf(ziElement1.elementText("售价")));
            books.add(book);
            //}
            for (Book book2 : books) {
                System.out.println(book2);
            }
        }

        System.out.println("-------------------分割线-------------------");
        //获取根元素下的所有武侠小说标签子元素
        List<Element> ziElements2 = root.elements("武侠小说");
        for (Element ziElement2 : ziElements2) {
            System.out.println("--------------------");
            System.out.print(ziElement2.getName() + "(");   //遍历显示标签名称
            Attribute id = ziElement2.attribute("id");  //获取标签属性
            Attribute type = ziElement2.attribute("type");  //获取标签属性
            System.out.print(id.getValue() + "  ");  //显示标签的属性值
            System.out.println(type.getValue() + ")");  //显示标签的属性值
            System.out.print(ziElement2.attributeValue("id") + "  ");  //直接获取属性值
            System.out.println(ziElement2.attributeValue("type"));  //直接获取属性值
            System.out.println("--------------------");
            //获取武侠小说元素下的所有子元素
            List<Element> wxElements = ziElement2.elements();
            for (Element wxElement : wxElements) {
                System.out.println(wxElement.getName());    //遍历显示标签名称
                System.out.println(wxElement.getTextTrim());    //遍历显示标签文本 去掉前后空格
                System.out.println(ziElement2.elementText(wxElement.getName()));    //通过上一级标签显示其某个指定子标签的标签文本 包含前后空格
            }

        }

    }
}
