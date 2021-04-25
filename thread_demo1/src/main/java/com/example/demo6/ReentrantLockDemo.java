package com.example.demo6;


import java.util.concurrent.locks.ReentrantLock;

//买票 使用reentrantLock
public class ReentrantLockDemo {
    public static void main(String[] args) {
        Ticketss tickets=new Ticketss();

        Thread thread1=new Thread(tickets,"1");
        Thread thread2=new Thread(tickets,"2");
        Thread thread3=new Thread(tickets,"3");
        thread1.start();
        thread2.start();
        thread3.start();
    }




}
@Data
class Ticketss implements Runnable{
    private int num=10;

    private final ReentrantLock reentrantLocks=new ReentrantLock();


    @Override
    public void run() {

        while (true){
            try {
                reentrantLocks.lock();
                if (num > 0) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(num--);

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                } else {
                    break;
                }
            }finally {
                reentrantLocks.unlock();
            }
        }

    }

}
