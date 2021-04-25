package com.example.demo4;

//守护线程
public class DaemonDemo {
    public static void main(String[] args) {


        Thread thread1=new Thread(()->{
            //正常会一直执行，但thread1是守护线程，所以其他线程执行完，thread1也关闭
            while (true){
                System.out.println("my god");
            }
        });
        thread1.setDaemon(true);

        thread1.start();
        new Thread(()->System.out.println("happy")).start();


    }



}


