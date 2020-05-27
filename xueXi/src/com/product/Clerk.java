package com.product;

public class Clerk {

    private int productCount=0;

    // 生成产品
    public synchronized void produceProject(){
        if(productCount < 20){
            productCount++;
            System.out.println(Thread.currentThread().getName()+"生产出"+productCount);
            notify();
        }else {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    // 消费产品
    public synchronized void consumerProject() {
        if(productCount>0){
            System.out.println(Thread.currentThread().getName()+"购买了"+productCount);
            productCount--;
            notify();
        }else {
            // 等待
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
