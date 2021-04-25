package com.example.demo7;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//线程池
public class ThreadPoolDemo  {

    public static void main(String[] args) {
        MyThread thread=new MyThread();
        //创建服务，创建线程池
        //newFixedThreadPool 参数线程池大小
        ExecutorService service= Executors.newFixedThreadPool(4);

        //执行1
        service.execute(thread);
        service.execute(thread);
        service.execute(thread);
        service.execute(thread);

        //关闭连接
        service.shutdown();
    }

}


class MyThread implements Runnable{

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
    }
}
