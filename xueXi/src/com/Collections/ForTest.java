package com.Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;

/**
 * jdk5.0 新增了foreach 循环，用于遍历集合、数组
 * @author RZ
 * @date 2020/6/17 15:50
 */
public class ForTest {
    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);

        for (Object ob: coll) {
            System.out.println(ob);

        }
    }
}
