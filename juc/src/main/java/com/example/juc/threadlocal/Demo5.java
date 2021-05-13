package com.example.juc.threadlocal;

public class Demo5 {
    static  ThreadLocal<String> threadLocal=new ThreadLocal<>();
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            int finalI = i;
            new Thread(()->{
                threadLocal.set(finalI+"");

                System.out.println(threadLocal.get());

            }).start();


        }



    }
}
