package com.example.demo1;

//实现runnable代码可在多个线程中复用    继承thread即使run代码一样也还是需要重写一个类
public class TestThread03 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run开始执行第"+i+"次");
        }
    }

    public static void main(String[] args) {
        TestThread03 thread=new TestThread03();
        Thread thread1=new Thread(thread);
        ordinaryCall(thread1);
        //threadCall(thread1);
    }
    //多线程执行   run   main由操作系统决定执行顺序   可看见交替执行
    public static void threadCall(Thread thread){

        thread.start();//

        for (int i = 0; i < 200; i++) {
            System.out.println("main执行"+i+"次");

        }
    }



    //普通执行  按照代码顺序执行  run调用完 -> main
    public static  void ordinaryCall(Thread thread){


        thread.run();

        for (int i = 0; i < 200; i++) {
            System.out.println("main执行"+i+"次");

        }
    }
}
