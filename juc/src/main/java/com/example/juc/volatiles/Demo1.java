package com.example.juc.volatiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * volatile 在多线程下保证可见性
 */
public class Demo1 {

    /**
     * 不加volatile程序死循环，线程间值修改不可见
     *
     */
    private  volatile  static int num = 0;

    public static void main(String[] args) throws InterruptedException {

        new Thread(()->{
            while(num==0){

            }
        }).start();


        TimeUnit.SECONDS.sleep(2);

        num=1;
        System.out.println(num);






    }
}
