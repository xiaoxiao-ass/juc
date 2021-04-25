package com.example.demo4;

//获取线程执行状态q
public class ThreadStateDemo {


    public static void main(String[] args) {

        Thread thread1=new Thread(()->{
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("-------------");
        });
        Thread.State  state=thread1.getState();
        System.out.println(state);

        thread1.start();
        state=thread1.getState();
        System.out.println(state);


        while (thread1.getState()!=Thread.State.TERMINATED){
            state=thread1.getState();
            System.out.println(state);
        }

        System.out.println(thread1.getState());

    }
}
