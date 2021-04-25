package com.example.demo7;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class Integrate {
    public static void main(String[] args) {
     new A().start();
     new Thread(new B()).start();



        FutureTask<Integer> task=new FutureTask(new C());
        new Thread(task).start();
        try {
           Integer a= task.get();
            System.out.println(a);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }


    }
}


//多种创建线程方式

class A extends  Thread{
    @Override
    public void run() {
        System.out.println("thread");
    }
}

class B implements  Runnable{
    @Override
    public void run() {
        System.out.println("Runnable");
    }
}


class C implements Callable<Integer> {
    @Override
    public Integer call() {
        System.out.println("Callable");
        return 100;
    }
}
