package com.Person;

import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * @author RZ
 * @date 2020/5/27 23:49
 */
public class PersonTest {
    // 反射之前，对Person的操作
    @Test
    public void Persontest1(){
        // 1.创建Person类的对象
        Person person =new Person("Tom",12);

        // 2.通过对象，调用其内部的属性、方法
        person.age=10;
        System.out.println(person.toString());
    }

    // 反射之后
    @Test
    public void Persontest2() throws Exception{
        Class cla= Person.class;
        // 1.通过反射，创建Person类的对象
        Constructor cons= cla.getConstructor(String.class,int.class);

        Object obj=cons.newInstance("Tom",12);
        // 接收
        Person p = (Person) obj;
        System.out.println(obj.toString());
        // 2.通过反射，调用对象指定的属性、方法
        // 获取公有age变量
        Field age = cla.getDeclaredField("age");
        // 重新传值
        age.set(p,100);
        System.out.println(obj.toString());

        // 反射调用类里的方法
        Method sh = cla.getDeclaredMethod("show");
        // 传入类，表示调用哪个类的方法
        sh.invoke(p);

        // 通过反射，可以调用Person类的私有构造。比如：私有的构造器、方法、属性。
        // 调用私有构造器
        Constructor cl1=cla.getDeclaredConstructor(String.class);
        // 变为修改
        cl1.setAccessible(true);
        Person p1= (Person) cl1.newInstance("kiu");
        System.out.println(p1);

        // 获取私有有age变量
        Field na = cla.getDeclaredField("name");
        // 变为修改
        na.setAccessible(true);
        // 类，值
        na.set(p1,"hanMeimei");
        System.out.println(p1);

        Method showNation = cla.getDeclaredMethod("showNation",String.class);
        showNation.setAccessible(true);
        showNation.invoke(p1,"中国"); // 相当于 类.showNation(value)

    }

    @Test
    public void test4() throws ClassNotFoundException {
        // 方式一：调用运行时类的属性：.class
        Class clas=Person.class;
        System.out.println(clas);

        // 方式二：通过运行时类的对象，调用getClass()
        Person p1 = new Person();
        Class clas2=p1.getClass();
        System.out.println(clas2);

        // 方式三：调用Class的静态方法：forname(String classPath)
        Class clas3 = Class.forName("com.Person.Person");

    }
}
