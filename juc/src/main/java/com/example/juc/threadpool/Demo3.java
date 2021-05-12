package com.example.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo3 {
    public static void main(String[] args) {
       ExecutorService executorService= Executors.newCachedThreadPool();


        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
