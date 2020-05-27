package com.Person;

/**
 * @author RZ
 * @date 2020/5/27 17:23
 */
public class Person {
    private String name;
    public int age;
    private String nation;
    public Person() {

    }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void show(){
        System.out.println("这是一个show:"+name+age);
    }


    private void showNation(String nation){
        System.out.println("这是一个showNation:"+nation);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
