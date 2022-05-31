package com.future.test;

import java.util.Objects;

/**
 * @author guorui
 * @create 2022-05-02-11:45
 */
public class Student {
    public Student(String name) {
        this.name = name;
    }

    private String name;
    private char sex;
    private int age;
    private String className;
    private String hobby;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return sex == student.sex &&
                age == student.age &&
                Objects.equals(name, student.name) &&
                Objects.equals(className, student.className) &&
                Objects.equals(hobby, student.hobby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, sex, age, className, hobby);
    }

    public Student() {
    }

    public Student(String name, char sex, int age, String className, String hobby) {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.className = className;
        this.hobby = hobby;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", sex=" + sex +
                ", age=" + age +
                ", className='" + className + '\'' +
                ", hobby='" + hobby + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }
}
