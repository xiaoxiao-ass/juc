package com.example.demo4;

//线程优先级 （1-10)  越高权重越大   start()前设置
public class PriorityDemo {


    public static void main(String[] args) {
        System.out.println("main优先级"+Thread.currentThread().getPriority());
        MyPriority myPriority=new MyPriority();


        Thread thread1=new Thread(myPriority,"a");
        Thread thread2=new Thread(myPriority,"b");
        Thread thread3=new Thread(myPriority,"c");

        thread1.start();

        thread2.setPriority(1);
        thread3.start();

        thread2.setPriority(10);
        thread2.start();



    }
}



class MyPriority implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"==>优先级==》"+Thread.currentThread().getPriority());
    }
}
