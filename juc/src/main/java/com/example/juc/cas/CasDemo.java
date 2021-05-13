package com.example.juc.cas;

import java.util.concurrent.atomic.AtomicInteger;

public class CasDemo {
    public static void main(String[] args) {
        // CAS compareAndSet : 比较并交换！
        AtomicInteger integer=new AtomicInteger(2010);
        // 期望、更新 // public final boolean compareAndSet(int expect, int update) // 如果我期望的值达到了，那么就更新，否则，就不更新, CAS 是CPU的并发原语！
        integer.compareAndSet(2010,2020);
        System.out.println(integer.get());
        integer.getAndIncrement();
        integer.compareAndSet(2020,30);
        System.out.println(integer.get());
    }
}
