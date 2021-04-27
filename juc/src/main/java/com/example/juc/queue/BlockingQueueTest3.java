package com.example.juc.queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * 阻塞等待
 */
public class BlockingQueueTest3 {
    public static void main(String[] args) throws InterruptedException {
        BlockingQueue<Integer> blockingQueue=new ArrayBlockingQueue(3);

        blockingQueue.put(1);
        blockingQueue.put(1);
        blockingQueue.put(1);
        blockingQueue.take();


    }
}
