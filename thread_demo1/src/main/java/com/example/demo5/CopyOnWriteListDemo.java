package com.example.demo5;

import java.util.concurrent.CopyOnWriteArrayList;

//CopyOnWriteArrayList 自带线程安全ArrayList
public class CopyOnWriteListDemo {
    public static void main(String[] args) throws InterruptedException {
        CopyOnWriteArrayList<String> list=new CopyOnWriteArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->{
                list.add("ddddd");
            }).start();
        }

        Thread.sleep(1000);
        System.out.println(list.size());
    }
}
