package com.test;

public class TestMain {
    public static void main(String[] args) {
        ThreadMyTest myTest1 = new ThreadMyTest();
        ThreadMyTest myTest2 = new ThreadMyTest();

        myTest1.start();
        myTest2.start();
    }
}
