package com.example.juc.demo01;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
//condition 可以指定唤醒线程
public class SpecialRunThread {
    public static void main(String[] args) {
        S c=new S();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.printA();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"a").start();



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.printB();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"b").start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.printC();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"c").start();

    }
}


class S {
    private int num = 1;
    Lock lock = new ReentrantLock();
    Condition condition1 = lock.newCondition();
    Condition condition2 = lock.newCondition();
    Condition condition3 = lock.newCondition();


    public void printA() throws InterruptedException {
        lock.lock();
        try {

            while (num !=1) {
                condition1.await();
            }
            System.out.println(num);
            num=2;

            condition2.signal();

        } finally {
            lock.unlock();
        }


    }


    public void printB() throws InterruptedException {
        lock.lock();
        try {
            while (num != 2) {
                condition2.await();
            }
            System.out.println(num);
            num=3;


            condition3.signal();

        } finally {
            lock.unlock();
        }

    }

    public void printC() throws InterruptedException {
        lock.lock();
        try {
            while (num != 3) {
                condition3.await();
            }
            System.out.println(num);
            num=1;

            condition1.signal();

        } finally {
            lock.unlock();
        }

    }
}
