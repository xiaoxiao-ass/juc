package com.example.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo4 {
    public static void main(String[] args) {


        ExecutorService executorService= Executors.newScheduledThreadPool(3);

        for (int i = 0; i < 5; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }

        executorService.shutdown();
    }
}
