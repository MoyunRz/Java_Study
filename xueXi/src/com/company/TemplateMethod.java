package com.company;

/**
 * 抽象类的应用：模板设计模式
 */
public class TemplateMethod {
    public static void main(String[] args) {
        SubTemplate sub =new SubTemplate();
        sub.spendTime();
    }

}

abstract class Template{

    public void spendTime(){
        long  start =System.currentTimeMillis();
        this.code();
        long end =System.currentTimeMillis();
        System.out.println("时间花费："+(end-start));
    }

    public abstract void code();
}

class SubTemplate extends Template{

    @Override
    public void code(){
        for (int i=2;i<1000;i++){
            boolean isFlag = true;
            for (int j=2;j<=Math.sqrt(i);j++){
                 if(i%j==0){
                     isFlag=false;
                     break;
                 }
            }
            if(isFlag){
                System.out.println(i);
            }
        }
    }
}