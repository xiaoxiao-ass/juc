package com.example.juc.demo01;



//生产者消费者问题 等待唤醒  通知唤醒： 1个生产者一个消费者不存在问题    多个生产者或者多个消费者会出现虚假唤醒问题
public class ProducerCustomerDemo1 {

    public static void main(String[] args) {
        C c=new C();
        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.add();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();



        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                try {
                    c.reduce();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}



class C{
    private int num=0;

    public synchronized  void add() throws InterruptedException {
      if(num!=0){
          wait();
      }
      num++;
        System.out.println(num);
      notifyAll();

    }


    public synchronized  void reduce() throws InterruptedException {
       if(num==0){
           wait();
       }
       num--;
        notifyAll();
        System.out.println(num);

    }
}