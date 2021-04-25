package com.example.demo5;
//不安全买票，可能买到同一张票
public class UnsafeThreadDemo1 {
    public static void main(String[] args) {
        Ticket ticket=new Ticket();

        Thread thread1=new Thread(ticket,"老师");
        Thread thread2=new Thread(ticket,"学生");
        Thread thread3=new Thread(ticket,"小");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class  Ticket implements Runnable{

    private int num=10;

    private boolean flag=true;


    @Override
    public void run() {
        while (flag){
            try {
                buy();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


    public void buy() throws InterruptedException {

        if(num>0){
            System.out.println(Thread.currentThread().getName()+"==>"+num--);
            Thread.sleep(300);
        }else {
            flag=false;
            return;
        }
    }
}
