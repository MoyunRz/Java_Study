package com.TPool;

import java.util.concurrent.*;

/**
 * @author RZ
 * @date 2020/6/20 14:56
 */
public class ThreadPoolTest {
    public static void main(String[] args) {
//        ExecutorService executor = Executors.newFixedThreadPool(6);
//        for (int i = 0; i < 10; i++) {
//            executor.submit(() -> {
//                System.out.println("thread id is: " + Thread.currentThread().getId());
//                try {
//                    Thread.sleep(1000L);
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//            });
//        }

        /**
         *
         * scheduleAtFixedRate(Runnable command, long initialDelay, long period, TimeUnit unit)，定时调度，每个调度任务会至少等待period的时间，如果任务执行的时间超过period，则等待的时间为任务执行的时间
         *
         * scheduleWithFixedDelay(Runnable command, long initialDelay, long delay, TimeUnit unit)，定时调度，第二个任务执行的时间 = 第一个任务执行时间 + delay
         *
         * schedule(Runnable command, long delay, TimeUnit unit)，定时调度，延迟delay后执行，且只执行一次
         *
         */
//            ScheduledExecutorService executor = Executors.newScheduledThreadPool(2);
//
//        // 定时调度，每个调度任务会至少等待`period`的时间，
//        // 如果任务执行的时间超过`period`，则等待的时间为任务执行的时间
//        executor.scheduleAtFixedRate(() -> {
//            try {
//                Thread.sleep(10000);
//                // 获取执行时间
//                System.out.println(System.currentTimeMillis() / 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 0, 2, TimeUnit.SECONDS);
//
//        // 定时调度，第二个任务执行的时间 = 第一个任务执行时间 + `delay`
//        executor.scheduleWithFixedDelay(() -> {
//            try {
//                Thread.sleep(5000);
//                System.out.println(System.currentTimeMillis() / 1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }, 0, 2, TimeUnit.SECONDS);
//
//        // 定时调度，延迟`delay`后执行，且只执行一次
//        executor.schedule(() -> System.out.println("5 秒之后执行 schedule"), 5, TimeUnit.SECONDS);

        /**
         * int corePoolSize, // 核心线程数
         * int maximumPoolSize,// 最大线程数
         * long keepAliveTime,// 空闲时间，当线程池数量超过核心线程数时，多余的空闲线程存活的时间，即：这些线程多久被销毁
         * TimeUnit unit,// 空闲时间的单位，可以是毫秒、秒、分钟、小时和天，等等
         * BlockingQueue<Runnable> workQueue,// 等待队列，线程池中的线程数超过核心线程数时，任务将放在等待队列，它是一个BlockingQueue类型的对象
         * ThreadFactory threadFactory,// 线程工厂，我们可以使用它来创建一个线程
         * RejectedExecutionHandler handler// 拒绝策略，当线程池和等待队列都满了之后，需要通过该对象的回调函数进行回调处理
         */
        ExecutorService executor = new ThreadPoolExecutor(1, 1, 1, TimeUnit.SECONDS, new ArrayBlockingQueue<>(1)) {

            // 执行前
            @Override
            protected void beforeExecute(Thread t, Runnable r) {
                System.out.println("beforeExecute is called");
                // 获取线程数
                Long lg = getTaskCount();

                System.out.println(lg);
                // 获取线程池创建过的最大线程数
                System.out.println(getLargestPoolSize());
            }

            // 执行后
            @Override
            protected void afterExecute(Runnable r, Throwable t) {
                System.out.println("afterExecute is called");
                // 获取已经执行的数
                System.out.println(getCompletedTaskCount());
            }
            // 销毁后执行
            @Override
            protected void terminated() {
                System.out.println("terminated is called");
            }
        };

        executor.submit(() -> System.out.println("this is a task"));
        executor.shutdown();
    }
}
