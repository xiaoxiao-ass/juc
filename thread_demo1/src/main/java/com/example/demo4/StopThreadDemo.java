package com.example.demo4;

//设立标志位停止线程
public class StopThreadDemo implements Runnable{

    //线程标志位
   static boolean flag=true;

    public static void main(String[] args) {
        StopThreadDemo runnable=new StopThreadDemo();
        Thread thread=new Thread(runnable,"hhaha");
        thread.start();


        for (int i = 0; i < 100; i++) {
            System.out.println("main-----------"+i);
            if(i==90){
                updateSign();
                System.out.println("线程停止");
            }

        }
    }



    @Override
    public void run() {
        int i=0;
        while (flag){
            System.out.println("正在运行"+i++);
        }
    }


    public static void updateSign(){
        flag=false;
    }
}
