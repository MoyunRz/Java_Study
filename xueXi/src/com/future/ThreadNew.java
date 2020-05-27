package com.future;

import java.util.concurrent.Callable;

/**
 * Callable 第三种线程实现
 */
public class ThreadNew implements Callable {
    // 重写回调方法
    @Override
    public Object call() throws Exception {
        int sum=0;
        for (int i = 0; i <100 ; i++) {
            if(i%2==0){
                sum+=i;
            }
        }

        return sum;
    }
}
