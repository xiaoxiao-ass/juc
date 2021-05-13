package com.example.juc.cas;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicStampedReference;

public class CasDemo2 {
    public static void main(String[] args) {
        AtomicStampedReference atomicReference=new AtomicStampedReference(10,1);



        new Thread(()->{
            System.out.println(atomicReference.getStamp());
            atomicReference.compareAndSet(10,20,atomicReference.getStamp(),atomicReference.getStamp()+1);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(20,10,atomicReference.getStamp(),atomicReference.getStamp()+1);
            System.out.println(atomicReference.getStamp());

        },"A").start();

        new Thread(()->{
            int num=atomicReference.getStamp();
            System.out.println(num);
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            atomicReference.compareAndSet(10,20,num,num+1);
            System.out.println( atomicReference.getStamp());
        },"b").start();
    }
}
