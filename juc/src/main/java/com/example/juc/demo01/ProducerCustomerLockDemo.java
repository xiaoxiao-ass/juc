package com.example.juc.demo01;


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

//多个线程同时操作也没问题
public class ProducerCustomerLockDemo {

    public static void main(String[] args) {
        A c=new A();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();


        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

    }
}


class A{
    private int num=0;
    Lock lock=new ReentrantLock();
    Condition condition=lock.newCondition();


    public  void add() throws InterruptedException {
        lock.lock();
        try {

            while(num!=0){
          condition.await();
        }
        num++;
        System.out.println(num);
        condition.signalAll();

        }finally {
            lock.unlock();
        }


    }


    public   void reduce() throws InterruptedException {
        lock.lock();
        try {
            while(num==0){
                condition.await();
            }
            num--;
            System.out.println(num);
            condition.signalAll();

        }finally {
            lock.unlock();
        }

    }
}