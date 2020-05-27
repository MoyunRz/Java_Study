package com.stringUse;

import com.Person.Person;
import org.junit.Test;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * int length():返回字符串的长度：return value.length
 * char charAt(int index):返回某索引处的字符 return value[index]
 * boolean isEmpty():判断是否是空字符串：return value.length == 07
 * String toLowerCase():使用默认语言环境，将String 中的所有字符转为小写
 * String toUpperCase():使用默认语言环境，将String 中的所有字符转为大写
 * String trim():返回字符串的副本，忽略前导空白和尾部空白
 * boolean equals(Object obj):比较字符串的内容是否相同
 * boolean equalsIgnoreCase(String str) 功能与equals相似，忽略大小写
 * String concat(String str):将指定字符串连接到此字符串的结尾，等价于”+“
 * int compareTo(String str):比较两个字符串的大小
 * String substring(int beginIndex):返回一个新的字符串，它是此字符串的从beginIndex位置开始截取
 * String substring(int beginIndex，int endIndex):返回一个新的字符串，它是此字符串的从beginIndex位置开始截取到endIndex位置,
 */
public class stringUse {

    @Test
    public void test1(){
        String s1 = "helloworld";
        System.out.println(s1.length());
    }

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
}
