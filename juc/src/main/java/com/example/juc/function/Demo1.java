package com.example.juc.function;

import java.util.function.Function;

public class Demo1 {
    public static void main(String[] args) {
        Function<String,String> function=(str)-> "aaa";

        System.out.println(function.apply("ssjjsnu"));
    }
}
