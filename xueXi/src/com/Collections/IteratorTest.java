package com.Collections;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @author RZ
 * @date 2020/6/17 15:31
 */
public class IteratorTest {

    @Test
    public void test1(){
        Collection coll = new ArrayList();
        coll.add(123);
        coll.add(456);
        coll.add(new Person("jerry",20));
        coll.add(new String("Tom"));
        coll.add(false);
        Iterator iterator = coll.iterator();

        while (iterator.hasNext()){
            Object obj =iterator.next();
            if("Tom".equals(obj)){
                iterator.remove();
            }else {
                System.out.println(obj);
            }
        }
    }
}
