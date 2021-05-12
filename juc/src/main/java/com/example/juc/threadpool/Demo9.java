package com.example.juc.threadpool;

import java.util.concurrent.*;

// 自定义线程池！工作 ThreadPoolExecutor
// 最大线程到底该如何定义
// 1、CPU 密集型，几核，就是几，可以保持CPu的效率最高！
// 2、IO 密集型 > 判断你程序中十分耗IO的线程，
// 程序 15个大型任务 io十分占用资源！
public class Demo9 {
    public static void main(String[] args) {
// 获取CPU的核数 System.out.println(Runtime.getRuntime().availableProcessors());

        ExecutorService executorService=new ThreadPoolExecutor(
                3,
                Runtime.getRuntime().availableProcessors(),
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
