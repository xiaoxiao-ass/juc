package com.example.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 抛出异常  add 成功true  失败 抛出异常     remove 成功返回元素值 失败抛出异常    element成功返回队列首个元素  失败抛出异常
 */
public class BlockingQueueTest {
    public static void main(String[] args) {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue(3);

        //add 添加成功返回true 失败抛出异常
        System.out.println(blockingQueue.add(5));
        System.out.println(blockingQueue.add(2));
        System.out.println(blockingQueue.add(3));
        //add 添加元素 超过容量抛出异常 IllegalStateException: Queue full
        //System.out.println(blockingQueue.add(4));

        //remove移除元素，返回元素的值 失败抛出异常
        System.out.println(blockingQueue.remove());
        System.out.println(blockingQueue.remove());
       //System.out.println(blockingQueue.remove());
        //remove 移除元素 不够抛出异常 NoSuchElementException
       //System.out.println(blockingQueue.remove());

        //element返回队列首个元素   没有抛出异常 java.util.NoSuchElementException
        System.out.println(blockingQueue.element());







    }
}
