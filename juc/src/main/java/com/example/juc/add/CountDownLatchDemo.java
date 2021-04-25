package com.example.juc.add;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchDemo {
    public static void main(String[] args) throws InterruptedException {
        // 总数是6，必须要执行任务的时候，再使用！
        CountDownLatch countDownLatch=new CountDownLatch(6);
        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                System.out.println(Thread.currentThread().getName());
                countDownLatch.countDown();//-1
            },String.valueOf(i)).start();
        }

        //阻塞，等待countDownLatch为0
        countDownLatch.await();
       System.out.println("Close Door");
    }
}
