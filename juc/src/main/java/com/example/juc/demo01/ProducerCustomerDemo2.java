package com.example.juc.demo01;



//生产者消费者问题等待唤醒  通知唤醒： 1个生产者一个消费者不存在问题    多个生产者或者多个消费者会出现虚假唤醒问题    解决办法 使用while替换if   唤醒后while还会判断 if不会
public class ProducerCustomerDemo2 {

    public static void main(String[] args) {
        D d=new D();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    d.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    d.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    d.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    d.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}


class D{
    private int num=0;

    public synchronized  void add() throws InterruptedException {
        while (num!=0){
            wait();
        }
        num++;
        System.out.println(num);
        notifyAll();

    }


    public synchronized  void reduce() throws InterruptedException {
        while (num==0){
            wait();
        }
        num--;
        notifyAll();
        System.out.println(num);

    }
}


