package com.test;

import com.future.ThreadNew;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class ThreadNowTest {

    public static void main(String[] args) {
        ThreadNew  threadNew =new ThreadNew();
        FutureTask futureTask=new FutureTask(threadNew);
        new Thread(futureTask).start();
        Object sum = null;
        try {
            sum = futureTask.get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println(sum);

    }
}
