package com.example.juc.single;

public class Holder {

    private Holder(){

    }

    public static Holder getInstance(){
       return NestClass.holder;
    }

    public static class NestClass{
        private static final Holder holder=new Holder();
    }


    public static void main(String[] args) {
        System.out.println(getInstance());
    }
}
