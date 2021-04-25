package com.example.juc.demo01;



//synchronized实现买票
public class SaleTicketDemo01 {
    public static void main(String[] args) {
        Ticket tickets=new Ticket();
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


class Ticket{
    private int ticket=10;

    public synchronized void buyTicket(){
        if(ticket>0){
           // System.out.println(Thread.currentThread().getName()+"得到票"+"还剩"+ticket--+"张");
            System.out.println(Thread.currentThread().getName()+"卖出了"+(ticket--)+"票,剩余："+ticket);
        }
    }
}
