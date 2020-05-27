package com.test;

import com.product.Clerk;
import com.product.Consumer;
import com.product.Producer;

public class ProductTest {

    public static void main(String[] args) {
        Clerk clerk=new Clerk();
        Producer p1= new Producer(clerk);
        Consumer c1 = new Consumer(clerk);

        p1.setName("生产者1");
        c1.setName("消费者1");

        p1.start();
        c1.start();
    }
}

