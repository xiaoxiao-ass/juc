package com.example.demo5;

//线程安全买票
public class SafeTicket {
    public static void main(String[] args) {
        Tickets ticket=new Tickets();

        Thread thread1=new Thread(ticket,"老师");
        Thread thread2=new Thread(ticket,"学生");
        Thread thread3=new Thread(ticket,"小");
        thread1.start();
        thread2.start();
        thread3.start();
    }
}


class  Tickets implements Runnable{

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


    //同步方法
    public synchronized  void buy() throws InterruptedException {

        if(num>0){
            System.out.println(Thread.currentThread().getName()+"==>"+num--);
            Thread.sleep(300);
        }else {
            flag=false;
            return;
        }
    }
}
