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

}
