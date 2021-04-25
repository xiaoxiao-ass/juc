package com.example.demo3;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

public class StaticProxy {

    public static void main(String[] args) {
        //静态代理    Company代理Family的实现
        new Company(new Person()).beautifulHouse();

        //多线程中的代理     Thread 代理 Runnable实现
        new Thread(()-> System.out.println("hahahhaha")).start();

    }
}

class Person implements Family{

    @Override
    public void beautifulHouse() {
        System.out.println("住房子");
    }
}

@NoArgsConstructor
@AllArgsConstructor
class Company implements Family{

    private Family merry;

    @Override
    public void beautifulHouse() {
        before();
        this.merry.beautifulHouse();
        after();
    }


    public  void before(){
        System.out.println("布置房间");
    }

    public void after(){
        System.out.println("收取费用");
    }
}


interface Family{
    void beautifulHouse();
}
