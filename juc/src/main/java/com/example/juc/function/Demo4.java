package com.example.juc.function;

import java.util.function.Consumer;

public class Demo4 {
    public static void main(String[] args) {
        Consumer<Integer> consumer=(params)->{
            System.out.println(params);
        };


        consumer.accept(1);

    }
}
