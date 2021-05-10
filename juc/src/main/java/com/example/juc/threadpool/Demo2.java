package com.example.juc.threadpool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


public class Demo2 {
    public static void main(String[] args) {
       ExecutorService executorService= Executors.newFixedThreadPool(5);


        for (int i = 0; i < 10; i++) {
            executorService.execute(()->{
                System.out.println(Thread.currentThread().getName());
            });
        }
    }
}
