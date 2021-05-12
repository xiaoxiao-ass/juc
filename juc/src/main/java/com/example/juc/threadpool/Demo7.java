package com.example.juc.threadpool;

import java.util.concurrent.*;


public class Demo7 {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                //DiscardPolicy超过线程数，丢弃
                new LinkedBlockingDeque<>(5),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardPolicy());

        for (int i = 0; i < 11; i++) {
         executorService.execute(()->{
             System.out.println(Thread.currentThread().getName());
         });
        }
        executorService.shutdown();

    }
}
