package com.example.juc.volatiles;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Demo3 {
     static volatile AtomicInteger atomicInteger=new AtomicInteger();

     public static void add(){
         atomicInteger.getAndIncrement();
     }

    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(20);
        for (int i = 1; i <=20; i++) {
            new Thread(()->{
                for (int i1 = 0; i1 <1000; i1++) {
                    add();
                }

                countDownLatch.countDown();
            }).start();

        }

        System.out.println("-------------");

        //防止主线程退出
        countDownLatch.await();


        TimeUnit.SECONDS.sleep(2);

        System.out.println(atomicInteger);


    }
}
