package com.example.demo1;

//基本操作   1继承Thead   2 重写run()   3 start() 开启线程
//注意：线程开启不一定立即执行，由cpu调度执行
public class TestThread extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++) {
            System.out.println("run开始执行第"+i+"次");
        }
    }

    public static void main(String[] args) {
        TestThread thread=new TestThread();
        ordinaryCall(thread);
        //threadCall(thread);
    }
    //多线程执行   run   main由操作系统决定执行顺序   可看见交替执行
    public static void threadCall( Thread thread){

        thread.start();//

        for (int i = 0; i < 200; i++) {
            System.out.println("main执行"+i+"次");

        }
    }



    //普通执行  按照代码顺序执行  run调用完 -> main
    public static  void ordinaryCall( Thread thread){


        thread.run();

        for (int i = 0; i < 200; i++) {
            System.out.println("main执行"+i+"次");

        }
    }
}
