package com.example.juc.function;

import java.util.function.Predicate;

public class Demo3 {
    public static void main(String[] args) {
        Predicate<String> predicate=(bool)->bool.equals("ss");

        System.out.println(predicate.test("ed"));
    }
}
