package com.company;

public class RunableTest implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            if(i%2==0){
                System.out.println(Thread.currentThread().getName()+":"+i);
            }
        }
    }
}

class RunableMain{
    public static void main(String[] args) {
        RunableTest runableTest =new RunableTest();
        Thread thread1 = new Thread(runableTest, "窗口一");
        thread1.start();
    }
}
