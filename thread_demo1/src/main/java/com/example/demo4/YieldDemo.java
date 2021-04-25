package com.example.demo4;


//yield礼让    礼让有可能失败    cpu决定
public class YieldDemo implements Runnable{


    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"执行");
        Thread.yield(); //礼让
        System.out.println(Thread.currentThread().getName()+"停止");

    }

    public static void main(String[] args) {
        YieldDemo runnable=new YieldDemo();

        Thread thread1=new Thread(runnable);
        Thread thread2=new Thread(runnable);
        thread2.start();
        thread1.start();
    }





}
