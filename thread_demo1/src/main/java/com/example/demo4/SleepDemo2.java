package com.example.demo4;


import java.text.SimpleDateFormat;
import java.util.Date;

//sleep模拟获取系统时间
public class SleepDemo2 implements Runnable{


    @Override
    public void run() {
       int a=10;
        Date date=new Date(System.currentTimeMillis());
       while (true){
           if(a>0){
               try {
                   Thread.sleep(1000);
                   System.out.println(new SimpleDateFormat("HH:mm:ss").format(date));
                   date=new Date(System.currentTimeMillis());
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }

       }
    }

    public static void main(String[] args) {
        SleepDemo2 runnable=new SleepDemo2();

        Thread thread1=new Thread(runnable);
        thread1.start();
    }





}
