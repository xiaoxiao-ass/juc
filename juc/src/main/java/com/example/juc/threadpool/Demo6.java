package com.example.juc.threadpool;

import java.util.concurrent.*;


public class Demo6 {
    public static void main(String[] args) {
        ExecutorService executorService=new ThreadPoolExecutor(
                3,
                5,
                1,
                TimeUnit.SECONDS,
                //CallerRunsPolicy超过线程数，将有返回给线程的调用者执行  哪里来回哪里去
                new LinkedBlockingDeque<>(5),Executors.defaultThreadFactory(),new ThreadPoolExecutor.CallerRunsPolicy());

        for (int i = 0; i < 11; i++) {
         executorService.execute(()->{
             System.out.println(Thread.currentThread().getName());
         });
        }
        executorService.shutdown();

    }
}
