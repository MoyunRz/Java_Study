package com.company;

/**
 * volatile 变量自增运算测试
 *
 * @author mk
 */
public class VolatileTest {

    public static volatile int race = 0;

    public static void increase() {
        race++;
    }

    private static final int THREADS_COUNT = 20;

    public static void main(String[] args) {
        // 创建线程数组
        Thread[] threads = new Thread[THREADS_COUNT];
        // 遍历执行线程
        for (int i = 0; i < THREADS_COUNT; i ++) {
            // 创建线程
            threads[i] = new Thread(new Runnable() {
                // 重写
                @Override
                public void run() {
                    for (int i = 0; i < 100; i++) {
                        increase();
                    }
                }
            });
            // 执行线程
            threads[i].start();
        }

        // 等待所有累加线程都结束
        while (Thread.activeCount() > 1)
            Thread.yield();
        System.out.println(race);
    }
}

