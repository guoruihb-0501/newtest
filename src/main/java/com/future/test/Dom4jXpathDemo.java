package com.future.test;

import org.dom4j.*;
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
 * @create 2022-05-10-14:10
 */
public class Dom4jXpathDemo {
    @Test
    //绝对路径
    public void dom4jXpathDemoTest1() throws Exception {
        //创建1个dom4j解析器对象 SAXReader，代表了整个dom4j框架
        SAXReader sr = new SAXReader();
        //加载xml文件成为一个DOCMENT对象
        //从工程根目录开始定位xml文件  java.io默认定位到工程根目录
        Document document = sr.read(new File("./src/main/webapp/WEB-INF/data.xml"));
        List<Node> nameNodes = document.selectNodes("/书架/武侠小说/书名");
        for (Node nameNode : nameNodes) {
            Element element = (Element) nameNode;
            System.out.println(element.getTextTrim());
        }
    }
    @Test
    //相对路径
    public void dom4jXpathDemoTest2() throws Exception {
        //创建1个dom4j解析器对象 SAXReader，代表了整个dom4j框架
        SAXReader sr = new SAXReader();
        //加载xml文件成为一个DOCMENT对象
        //从工程根目录开始定位xml文件  java.io默认定位到工程根目录
        Document document = sr.read(new File("./src/main/webapp/WEB-INF/data.xml"));
        Element root = document.getRootElement();
        System.out.println("--------分割线--------");
        //按相对路径查找指定标签的元素
        List<Node> nameNodes1 = document.selectNodes("//书名");
        for (Node nameNode1 : nameNodes1) {
            Element element1 = (Element) nameNode1;
            System.out.println(element1.getTextTrim());
        }
        System.out.println("--------分割线--------");
        //按相对路径在指定标签下查找指定标签的元素
        List<Node> nameNodes3 = document.selectNodes("//武侠小说/书名");
        for (Node nameNode3 : nameNodes3) {
            Element element3 = (Element) nameNode3;
            System.out.println(element3.getTextTrim());
        }
    }
    @Test
    //属性查找
    public void dom4jXpathDemoTest3() throws Exception {
        //创建1个dom4j解析器对象 SAXReader，代表了整个dom4j框架
        SAXReader sr = new SAXReader();
        //加载xml文件成为一个DOCMENT对象
        //从工程根目录开始定位xml文件  java.io默认定位到工程根目录
        Document document = sr.read(new File("./src/main/webapp/WEB-INF/data.xml"));
        Element root = document.getRootElement();

        //查找所有指定元素
        List<Node> nameNodes4 = document.selectNodes("//@id");   //这种查找方法获得的节点是属性而不是元素
        for (Node nameNode4 : nameNodes4) {
            Attribute attr1 = (Attribute) nameNode4;
            System.out.println(attr1.getName() + "  " + attr1.getValue());
        }
        System.out.println("--------分割线--------");
        //在指定标签之下查找指定元素
        List<Node> nameNodes5 = document.selectNodes("//武侠小说[@id]");
        for (Node nameNode5 : nameNodes5) {
            Element element5 = (Element) nameNode5;
            System.out.println(element5.getName());
        }
        System.out.println("--------分割线--------");
        //查找指定属性id=2的元素
        Node node6 = document.selectSingleNode("//武侠小说[@id=2]");
        Element element6 = (Element)node6;
        System.out.println(element6.getName());
    }
}
