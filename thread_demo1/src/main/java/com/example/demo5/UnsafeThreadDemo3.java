package com.example.demo5;

import java.util.ArrayList;
import java.util.List;

//ArrayList线程不安全  当使用多线程时，被多个线程线程共同操作的位置会被覆盖   list大小不会有1000次
public class UnsafeThreadDemo3 {
    public static void main(String[] args) {
        List<String> list=new ArrayList<String>();
        for (int i = 0; i < 1000; i++) {
            new Thread(()->list.add("jahahhaha")).start();
        }
        System.out.println(list.size());
    }
}
