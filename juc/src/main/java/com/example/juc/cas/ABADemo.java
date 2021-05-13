package com.example.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 没有感知中间值已被修改过
 */
public class ABADemo {
    public static void main(String[] args) {
        AtomicInteger integer=new AtomicInteger(20);


        integer.compareAndSet(20,11);
        integer.compareAndSet(11,20);
        integer.compareAndSet(20,22);
        System.out.println(integer.get());
    }
}
