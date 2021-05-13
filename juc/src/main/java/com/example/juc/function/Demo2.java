package com.example.juc.function;

import java.util.function.Supplier;

public class Demo2 {
    public static void main(String[] args) {
        Supplier<String> supplier=()->{
            System.out.println("aaaa");
           return "supplier";
        };

        System.out.println(supplier.get());
    }
}
