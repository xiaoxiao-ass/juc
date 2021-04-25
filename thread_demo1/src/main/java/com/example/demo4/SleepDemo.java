package com.example.demo4;


//sleep模拟倒计时
public class SleepDemo implements Runnable{


    @Override
    public void run() {
       int a=10;
       while (true){
           if(a>0){
               try {
                   Thread.sleep(1000);
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
               System.out.println(a--);
           }

       }
    }

    public static void main(String[] args) {
        SleepDemo runnable=new SleepDemo();

        Thread thread1=new Thread(runnable);
        thread1.start();
    }





}
