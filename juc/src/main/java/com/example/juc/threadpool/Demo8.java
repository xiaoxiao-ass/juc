package com.example.juc.threadpool;

import java.util.concurrent.*;


public class Demo8 {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                //DiscardOldestPolicy超过线程数，与老线程进行竞争获取
                new LinkedBlockingDeque<>(5),Executors.defaultThreadFactory(),new ThreadPoolExecutor.DiscardOldestPolicy());

        for (int i = 0; i < 11; i++) {
         executorService.execute(()->{
             System.out.println(Thread.currentThread().getName());
         });
        }
        executorService.shutdown();

    }
}
