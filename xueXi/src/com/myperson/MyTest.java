package com.myperson;

import org.junit.Test;

import java.lang.reflect.Field;

/**
 * @author RZ
 * @date 2020/5/28 0:14
 */
public class MyTest {

    @Test
    public void test1(){

        Class clazz = MyPerson.class;
        // 获取属性结构
        // getFields(): 获取当前运行时类及其父类中声明为public访问权限的属性
        Field[] fields = clazz.getFields();

        for (Field f : fields) {
            System.out.println(f);
        }

       Field[] fields1 = clazz.getDeclaredFields();

        for (Field f : fields1) {
            System.out.println(f);
        }
    }
}
