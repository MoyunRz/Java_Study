package com.Collections;

import org.junit.Test;

import java.util.LinkedList;

/**
 * |---Collection接口：单例集合，用来存储一个个的对象
 *      |---List接口：存储有序的、可重复的数据。 --> "动态"数组，替换原有的数组
 *          |---ArrayList: 作为List接口的主要实现类 jdk1.2，线程不安全，效率高，底层使用Object[] elementData 实现
 *          |---LinkedList：对于频繁的增加和删除操作使用这个效率比ArrayList高，底层使用双向链表实现
 *          |---Vector：存储有序的可重复数据，作为List接口的古老实现类 jdk1，线程安全，效率低
 *
 *
 * 面试题：ArrayList、LinkedList、Vector三者的异同
 *
 * 同：三个类都是实现了List接口，存储数据的特点相同：存储有序的、可重复的数据
 *
 * @author RZ
 * @date 2020/6/17 15:57
 */
public class ListTest {

    @Test
    public void test1(){
        LinkedList linkedList =new LinkedList();

    }
}
