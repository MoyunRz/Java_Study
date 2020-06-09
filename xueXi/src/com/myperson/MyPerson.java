package com.myperson;
/**
 * @author RZ
 * @date 2020/5/27 17:23
 */
@MyAnnotation(value = "MyPerson")
public class MyPerson extends Creature<String> implements Comparable<String> ,MyInterface {

    private String name;
    int age;
    public  int id;

    public MyPerson(){}
    @MyAnnotation(value = "private")
    private MyPerson(String name){
        this.name=name;
    }
    @MyAnnotation(value = "public")
    MyPerson(String name,int age){
        this.name=name;
        this.age=age;
    }

    @MyAnnotation(value = "show")
    private String show(String nation){

        System.out.println("这是一个:"+nation);

        return nation;
    }

    public String display(String interests){

        return interests;

    }

    @Override
    public void info() {
        System.out.println("一个人");
    }

    @Override
    public int compareTo(String o) {
        return 0;
    }
}
