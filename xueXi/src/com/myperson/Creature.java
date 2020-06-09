package com.myperson;

import java.io.Serializable;

/**
 * @author RZ
 * @date 2020/5/27 23:55
 */
public class Creature<T> implements Serializable {
    private char gender;
    public double weight;

    private void breath(){
        System.out.println("生物呼吸");
    }

    public void eat(){
        System.out.println("生物吃饭");
    }

}
