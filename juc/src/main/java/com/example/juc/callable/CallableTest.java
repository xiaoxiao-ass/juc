package com.example.juc.callable;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

      // new Thread(new Runnable()).start();
        // new Thread(new FutureTask<V>()).start();
        // new Thread(new FutureTask<V>( Callable )).start();
        FutureTask<Integer> futureTask=new FutureTask<>(()->{
            System.out.println(Thread.currentThread().getName());
            return 1024;
        });

        //注意：1、有缓存
        new Thread(futureTask,"b").start();
        new Thread(futureTask,"a").start();
        // 2、结果可能需要等待，会阻塞！
        Integer a=futureTask.get();
        System.out.println(a);

    }
}


