package com.example.demo4;


//sleep模拟倒计时
public class JoinDemo implements Runnable{


    @Override
    public void run() {
        for (int i = 0; i <= 50; i++) {
            System.out.println(Thread.currentThread().getName()+"执行--------"+i);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        JoinDemo runnable=new JoinDemo();

        Thread thread1=new Thread(runnable,"hhhdhdhhhd");
        thread1.start();


        for (int i = 0; i < 100; i++) {
            if(i==10){
                thread1.join();
            }
            System.out.println("main执行"+i);
        }

    }





}
