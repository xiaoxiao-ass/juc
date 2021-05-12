package com.example.juc.threadpool;

import java.util.concurrent.*;


public class Demo5 {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                //AbortPolicy超过线程数抛出异常
                new LinkedBlockingDeque<>(5),Executors.defaultThreadFactory(),new ThreadPoolExecutor.AbortPolicy());

        for (int i = 0; i < 11; i++) {
         executorService.execute(()->{
             System.out.println(Thread.currentThread().getName());
         });
        }
        executorService.shutdown();

    }
}
