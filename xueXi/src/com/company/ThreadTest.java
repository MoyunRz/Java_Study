package com.company;

/**
 * 多线程的创建
 * 方法一：继承于thread类
 * 1. 创建一个继承于Thread类的子对象
 * 2. 重写Thread类的run()
 * 3. 创建Thread子类的对象
 * 4. 通过调用对象的start()方法启动线程
 */

// 1. 创建一个继承于Thread类的子对象
public class ThreadTest extends Thread {
 // 2. 重写Thread类的run()
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+": i="+i);
            }

        }
    }
}

class ThreadMain {

    public static void main(String[] args) {

        ThreadTest threadTest1 = new ThreadTest();
        threadTest1.start();
        for (int i = 0; i <100 ; i++) {
            if(i%2==0) {
                System.out.println("这是主线程");
            }
        }


    }
}