package com.example.juc.lock;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class SpinlockDemo {

    AtomicReference<Thread> atomicReference=new AtomicReference<>();

    public void lock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"lock");

        while (!atomicReference.compareAndSet(null,thread)){

        }
    }


    public void unLock(){
        Thread thread=Thread.currentThread();
        System.out.println(Thread.currentThread().getName()+"unlock");
        atomicReference.compareAndSet(thread,null);
    }


    public static void main(String[] args) {
        SpinlockDemo lock=new SpinlockDemo();
        new Thread(()->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unLock();
        },"TA").start();



        new Thread(()->{
            lock.lock();
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            lock.unLock();
        },"t2").start();
    }
}
