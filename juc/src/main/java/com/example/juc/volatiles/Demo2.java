package com.example.juc.volatiles;

import java.util.concurrent.TimeUnit;

/**
 * volatile 不保证原子性
 */
public class Demo2 {

    private  volatile  static int num = 0;

    public static void add(){
        //执行三步    1 get num    2 num++  3 put num
        num++;
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 < 1000; i1++) {
                    add();
                }
            }).start();
        }

        //至少会有两个线程   main   gc
        while (Thread.activeCount()>2){
            Thread.yield();
        }


        System.out.println(num);


    }




}
