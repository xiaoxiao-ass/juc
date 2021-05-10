package com.example.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.TimeUnit;

/**
 * SynchronousQueue同步队列 不存储元素   put了一个元素必须take   否则不能再put
 *
 */
public class BlockingQueueTest5 {
    public static void main(String[] args) {
        System.out.println("sssss");
        BlockingQueue<Integer> blockingQueue=new SynchronousQueue<>();
        new Thread(()->{
            try {
                System.out.println(Thread.currentThread().getName()+"put 1 ");
                blockingQueue.put(1);
                System.out.println(Thread.currentThread().getName()+"put 2 ");
                blockingQueue.put(2);
                System.out.println(Thread.currentThread().getName()+"put 3 ");
                blockingQueue.put(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();


        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"take"+ blockingQueue.take());
                TimeUnit.SECONDS.sleep(3);
                System.out.println(Thread.currentThread().getName()+"take"+ blockingQueue.take());
                TimeUnit.SECONDS.sleep(


                        3);
                System.out.println(Thread.currentThread().getName()+"take"+ blockingQueue.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }).start();




    }
}
