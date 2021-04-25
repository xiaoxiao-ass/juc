package com.example.demo1;

//抢火车票(会出现并发问题，数据紊乱)
//实现runnable代码可在多个线程中复用    继承thread即使run代码一样也还是需要重写一个类
public class TestThread04 implements Runnable{

    int num=10;
    @Override
    public void run() {
       while (true){
            if(num<=0){
              break;
            }
           System.out.println(Thread.currentThread().getName()+num--+"得到票");

       }
    }

    public static void main(String[] args) {
        //实现runnable代码可在多个线程中复用
        TestThread04 runnable=new TestThread04();

        Thread thread1=new Thread(runnable,"老师");
        Thread thread2=new Thread(runnable,"学生");
        Thread thread3=new Thread(runnable,"小");
        thread1.start();
        thread2.start();
        thread3.start();
    }





}
