package com.ThreadPool;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 创建线程池
 */
class NumberThread implements Runnable{
    int sum=0;
    @Override
    public void run() {
        for (int i = 0; i <100 ; i++) {
            sum+=i;
            System.out.println(sum);
        }
    }
}

public class ThreadPool {

    public static void main(String[] args) {
        // 创建线程数
        ExecutorService executorService = Executors.newFixedThreadPool(10);

        // 执行指定的线程 适合使用于Runable
        executorService.execute(new NumberThread());
        // 提交 执行指定的线程 适合使用于Callable
        // executorService.submit(Callable callable);
        // 关闭线程池
        executorService.shutdown();
    }


}
