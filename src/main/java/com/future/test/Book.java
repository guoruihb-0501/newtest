package com.future.test;

/**
 * @author guorui
 * @create 2022-05-09-16:40
 */
public class Book {
    private String name;
    private Integer id;
    private String type;
    private String writer;
    private double price;


    public Book() {
    }

    public Book(String name, Integer id, String type, String writer, double price) {
        this.name = name;
        this.id = id;
        this.type = type;
        this.writer = writer;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Book{" +
                "name='" + name + '\'' +
                ", id=" + id +
                ", type='" + type + '\'' +
                ", writer='" + writer + '\'' +
                ", price=" + price +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
