package com.example.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

/**
 * 有返回值不抛出异常     offer 成功true  失败false      poll 成功返回元素值  失败返回null    可设置超时时间，不阻塞
 */
public class BlockingQueueTest4 {
    public static void main(String[] args)throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue(3);


        //offer 添加元素  成功true 失败false 不抛出异常
        System.out.println(blockingQueue.offer(1));
        System.out.println(blockingQueue.offer(2));
        System.out.println(blockingQueue.offer(3));
        System.out.println(blockingQueue.offer(4,1, TimeUnit.SECONDS));

        System.out.println("----------------------------");
        //poll 移除元素  成功true 失败null 不抛出异常
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll());
        System.out.println(blockingQueue.poll(1,TimeUnit.SECONDS));


       // peek()
        //检索但不删除此队列的头，如果此队列为空，则返回 null 。
        System.out.println(blockingQueue.peek());




    }
}
