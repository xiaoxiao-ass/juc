package com.example.juc.add;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

//信号量   可被用作限流
public class SemaphoreDemo {
    public static void main(String[] args) {
        // 线程数量：停车位! 限流！
        Semaphore semaphore=new Semaphore(3);

        for (int i = 0; i < 6; i++) {
            new Thread(()->{
                try {
                    // acquire() 得到
                    semaphore.acquire();
                    System.out.println(Thread.currentThread().getName()+"得到车位");
                    TimeUnit.SECONDS.sleep(5);
                    System.out.println(Thread.currentThread().getName()+"离开车位");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    //释放
                    semaphore.release();
                }
            }).start();
        }
    }
}
