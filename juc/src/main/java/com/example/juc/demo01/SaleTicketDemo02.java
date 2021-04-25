package com.example.juc.demo01;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


//买票  lock实现
public class SaleTicketDemo02{
    public static void main(String[] args) {
        Ticket2 tickets=new Ticket2();
        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                tickets.buyTicket();
            }
        },"晓明").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                tickets.buyTicket();
            }
        },"小小").start();

        new Thread(()->{
            for (int i = 0; i < 20; i++) {
                tickets.buyTicket();
            }
        },"hhhaha").start();
    }
}


class Ticket2{
    private int ticket=10;

    Lock lock=new ReentrantLock();
    public  void buyTicket(){
        lock.lock();
        try{
            if(ticket>0){
                // System.out.println(Thread.currentThread().getName()+"得到票"+"还剩"+ticket--+"张");
                System.out.println(Thread.currentThread().getName()+"卖出了"+(ticket--)+"票,剩余："+ticket);
            }
        }finally {
            lock.unlock();
        }

    }
}
