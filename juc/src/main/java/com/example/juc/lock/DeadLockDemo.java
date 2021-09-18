package com.example.juc.lock;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * jps -l 查看运行的所有java进程      jstack  进程号  查看堆栈信息 可定位死锁
 */
public class DeadLockDemo {
    public static void main(String[] args) {
        String a="s";
        String b="ss";
        new Thread(new Test(a,b)).start();
        new Thread(new Test(b,a)).start();
    }
}

@Data
@AllArgsConstructor
class  Test implements Runnable{
    private String a;
    private String b;


    @Override
    public void run() {
        synchronized (a){
            System.out.println(a+""+Thread.currentThread().getName());

            synchronized (b){
                System.out.println(b+""+Thread.currentThread().getName());
            }
        }
    }
}