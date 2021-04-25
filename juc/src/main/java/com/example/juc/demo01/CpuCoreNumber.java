package com.example.juc.demo01;

public class CpuCoreNumber {
    public static void main(String[] args) {
        //获取cpu核数   例如8
        //cpu密集型 io密集型
        System.out.println(Runtime.getRuntime().availableProcessors());



        //获取指定线程当前状态
        System.out.println(new Thread(()-> System.out.println(Thread.currentThread().getName())).getState());


        //查看线程状态所有枚举值   点击 State查看
        // Thread.State
    }
}
