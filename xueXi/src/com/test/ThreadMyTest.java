package com.test;


public class ThreadMyTest extends Thread{

    public static volatile int stack=100;

    public static void increase() {
        --stack;
    }

    @Override
    public void run() {
        while (stack>0){
            System.out.println(Thread.currentThread().getName()+":卖票"+stack);
            increase();
        }

    }
}

