package com.example.juc.single;

/**
 * 饿汉式单例
 */
public class Hungry {

    private final static Hungry HUNGRY=new Hungry();

    private Hungry(){

    }

    public static Hungry getInstance(){
        return HUNGRY;
    }
}
